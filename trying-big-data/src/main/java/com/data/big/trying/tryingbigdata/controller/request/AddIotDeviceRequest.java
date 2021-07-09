package com.data.big.trying.tryingbigdata.controller.request;

import com.data.big.trying.tryingbigdata.domain.IotDevice;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Getter
@Slf4j
public class AddIotDeviceRequest {

    @NotBlank
    private String userId;

    @NotNull
    private Integer value;

    @NotNull
    private String type;

    @NotNull
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime createdAt;

    public IotDevice toIotDevice() {
        return IotDevice.builder()
            .userId(userId)
            .type(type)
            .value(value)
            .createdAt(createdAt)
            .build();
    }

}
