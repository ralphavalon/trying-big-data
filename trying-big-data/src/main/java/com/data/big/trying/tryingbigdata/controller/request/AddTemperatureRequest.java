package com.data.big.trying.tryingbigdata.controller.request;

import com.data.big.trying.tryingbigdata.domain.Temperature;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class AddTemperatureRequest {

    @NotBlank
    private String userId;

    @NotNull
    private Integer value;

    @NotNull
    private String type;

    @NotNull
    private LocalDateTime createdAt;

    public Temperature toTemperature() {
        return Temperature.builder()
            .userId(userId)
            .type(type)
            .value(value)
            .createdAt(createdAt)
            .build();
    }

}
