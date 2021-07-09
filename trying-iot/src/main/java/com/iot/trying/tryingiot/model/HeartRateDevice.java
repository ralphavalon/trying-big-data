package com.iot.trying.tryingiot.model;

import com.iot.trying.tryingiot.util.IntegerUtil;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class HeartRateDevice extends IotDevice {

    public HeartRateDevice(String userId, LocalDateTime createdAt) {
        super(userId, createdAt);
    }

    @Override
    public Integer getValue() {
        return IntegerUtil.getRandomIntegerBetweenRange(60, 120);
    }

    @Override
    public IotDevice.Type getType() {
        return IotDevice.Type.HEART_RATE;
    }
}
