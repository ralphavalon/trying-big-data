package com.data.big.trying.tryingbigdata.helper;

import com.data.big.trying.tryingbigdata.domain.IotDevice;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class TemperatureHelper {

    public static List<IotDevice> getTemperaturesEvenSize() {
        return Arrays.asList(
                temperature(30),
                temperature(35),
                temperature(33),
                temperature(40),
                temperature(37),
                temperature(39)
        );
    }

    public static List<IotDevice> getTemperaturesOddSize() {
        return Arrays.asList(
                temperature(30),
                temperature(33),
                temperature(40),
                temperature(37),
                temperature(39)
        );
    }

    private static IotDevice temperature(Integer value) {
        return IotDevice.builder()
            .userId("userId")
            .value(value)
            .type("THERMOSTAT")
            .createdAt(LocalDateTime.now())
            .build();
    }
}
