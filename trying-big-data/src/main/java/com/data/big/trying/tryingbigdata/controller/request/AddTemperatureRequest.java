package com.data.big.trying.tryingbigdata.controller.request;

import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import com.data.big.trying.tryingbigdata.domain.Temperature;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Getter
@Slf4j
public class AddTemperatureRequest {

    @NotBlank
    @JsonProperty("user_id")
    private String userId;

    @NotNull
    private Integer temperature;

    @NotBlank
    private String scale;

    @NotNull
    @JsonProperty("created_at")
    private Long createdAt;

    public Temperature toTemperature() {
        return Temperature.builder()
            .userId(userId)
            .scale(scale)
            .value(temperature)
            .createdAt(createdAt)
            .build();
    }

}
