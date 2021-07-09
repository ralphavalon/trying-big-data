package com.iot.trying.tryingiot.model;

import com.iot.trying.tryingiot.util.IntegerUtil;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
public class ThermostatDevice extends IotDevice {

    public ThermostatDevice(String userId, LocalDateTime createdAt) {
        super(userId, createdAt);
    }

    @Override
    public Integer getValue() {
        return IntegerUtil.getRandomIntegerBetweenRange(0, 40);
    }

    @Override
    public Type getType() {
        return Type.THERMOSTAT;
    }
}
