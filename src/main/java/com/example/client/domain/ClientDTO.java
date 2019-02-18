package com.example.client.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.Period;

@Data
@NoArgsConstructor
public class ClientDTO {
    private String name;
    private String sureName;
    private LocalDate birthDate;
    private LocalDate predictedDeathDate;

    public ClientDTO(ClientPersitent persitent) {
        this.name = persitent.getName();
        this.sureName = persitent.getSurename();
        this.birthDate = persitent.getBirthDate();
        this.predictedDeathDate = persitent.getPredictedDeathDate();
    }

    public int getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }
}
