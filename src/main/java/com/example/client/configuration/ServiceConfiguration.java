package com.example.client.configuration;

import com.example.client.repositories.ClientRepository;
import com.example.client.services.ClientService;
import com.example.client.services.DeathDateCalculator;
import com.example.client.services.PopulationService;
import com.example.client.services.impl.ClientServiceImpl;
import com.example.client.services.impl.DeathDateCalculatorImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Configuration
public class ServiceConfiguration {

    @Bean
    public DeathDateCalculator deathDateCalculator(PopulationService populationService) {
        return new DeathDateCalculatorImpl(populationService);
    }

    @Bean
    public ClientService clientService(ClientRepository repository, DeathDateCalculator deathDateCalculator) {
        return new ClientServiceImpl(repository, deathDateCalculator);
    }

    @Bean
    public Formatter<LocalDate> localDateFormatter() {
        return new Formatter<LocalDate>() {
            @Override
            public LocalDate parse(String s, Locale locale) throws ParseException {
                return LocalDate.parse(s, DateTimeFormatter.ISO_DATE);
            }

            @Override
            public String print(LocalDate localDate, Locale locale) {
                return DateTimeFormatter.ISO_DATE.format(localDate);
            }
        };
    }

    @Bean
    public ObjectMapper objectMapper() {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return objectMapper;
    }
}
