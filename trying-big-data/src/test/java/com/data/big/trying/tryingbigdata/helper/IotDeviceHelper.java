package com.data.big.trying.tryingbigdata.helper;

import com.data.big.trying.tryingbigdata.domain.IotDevice;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class IotDeviceHelper {

    public static List<IotDevice> getValuesEvenSize() {
        return Arrays.asList(
                device(30),
                device(35),
                device(33),
                device(40),
                device(37),
                device(39)
        );
    }

    public static List<IotDevice> getValuesOddSize() {
        return Arrays.asList(
                device(30),
                device(33),
                device(40),
                device(37),
                device(39)
        );
    }

    private static IotDevice device(Integer value) {
        return IotDevice.builder()
            .userId("userId")
            .value(value)
            .type("THERMOSTAT")
            .createdAt(LocalDateTime.now())
            .build();
    }
}
