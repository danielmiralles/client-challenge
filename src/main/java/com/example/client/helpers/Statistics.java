package com.example.client.helpers;

import com.example.client.domain.ClientKpiDTO;

import java.util.List;
import java.util.Objects;

public class Statistics {
    public static ClientKpiDTO computeStatistics(List<Integer> collection) {
        if (Objects.isNull(collection) || collection.isEmpty()) {
            return new ClientKpiDTO();
        }

        final double average =
                collection.stream()
                        .mapToDouble((x) -> x.doubleValue())
                        .summaryStatistics()
                        .getAverage();

        final double rawSum =
                collection.stream()
                        .mapToDouble((x) -> Math.pow(x.doubleValue() - average,
                                2.0))
                        .sum();

        final double standardDeviation = Math.sqrt(rawSum / (collection.size() - 1));

        return new ClientKpiDTO(average, standardDeviation);
    }
}
