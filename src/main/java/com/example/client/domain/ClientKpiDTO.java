package com.example.client.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientKpiDTO {
    private double ageAverage;
    private double standardDeviation;

    public ClientKpiDTO() {
        this.ageAverage = Double.NaN;
        this.standardDeviation = Double.NaN;
    }
}
