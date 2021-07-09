package com.iot.trying.tryingiot.model;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class IotDevice {
    protected String userId;
    protected LocalDateTime createdAt;

    public enum Type {
        HEART_RATE, THERMOSTAT, CAR_FUEL;
    }

    public abstract Integer getValue();
    public abstract Type getType();
}
