package com.example.client.services.impl;

import com.example.client.domain.ClientDTO;
import com.example.client.domain.PopulationResponse;
import com.example.client.services.DeathDateCalculator;
import com.example.client.services.PopulationService;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DeathDateCalculatorImpl implements DeathDateCalculator {

    private static final double DAYS_IN_YEAR = 365.2425d;

    private PopulationService populationService;

    public DeathDateCalculatorImpl(PopulationService populationService) {
        this.populationService = populationService;
    }

    @Override
    public ClientDTO predictDate(ClientDTO value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String birthDateFormatted = value.getBirthDate().format(formatter);
        Call<PopulationResponse> call = populationService.calculateLifeExpectancy(birthDateFormatted);
        try {
            Response<PopulationResponse> response = call.execute();
            PopulationResponse popResponse = response.body();
            double still = popResponse.getTotal_life_expectancy() - value.getAge();
            double stillInDays = still * DAYS_IN_YEAR;
            value.setPredictedDeathDate(LocalDate.now().plus((long) stillInDays, ChronoUnit.DAYS));

        } catch (IOException e) {
            value.setPredictedDeathDate(null);
        }

        return value;
    }
}
