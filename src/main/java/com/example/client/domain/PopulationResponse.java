package com.example.client.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PopulationResponse {
    private String dob;
    private String country;
    private double total_life_expectancy;
    private String sex;
}
