package com.iot.trying.tryingiot.model;

import com.iot.trying.tryingiot.util.IntegerUtil;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class CarFuelDevice extends IotDevice {

    public CarFuelDevice(String userId, LocalDateTime createdAt) {
        super(userId, createdAt);
    }

    @Override
    public Integer getValue() {
        return IntegerUtil.getRandomIntegerBetweenRange(0, 100);
    }

    @Override
    public Type getType() {
        return Type.CAR_FUEL;
    }
}
