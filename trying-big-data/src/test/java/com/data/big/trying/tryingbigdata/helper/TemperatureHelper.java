package com.data.big.trying.tryingbigdata.helper;

import com.data.big.trying.tryingbigdata.domain.Temperature;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TemperatureHelper {

    public static List<Temperature> getTemperaturesEvenSize() {
        return Arrays.asList(
                temperature(30),
                temperature(35),
                temperature(33),
                temperature(40),
                temperature(37),
                temperature(39)
        );
    }

    public static List<Temperature> getTemperaturesOddSize() {
        return Arrays.asList(
                temperature(30),
                temperature(33),
                temperature(40),
                temperature(37),
                temperature(39)
        );
    }

    private static Temperature temperature(Integer value) {
        return Temperature.builder()
            .userId("userId")
            .value(value)
            .scale("Celsius")
            .createdAt(new Date().toInstant().toEpochMilli())
            .build();
    }
}
