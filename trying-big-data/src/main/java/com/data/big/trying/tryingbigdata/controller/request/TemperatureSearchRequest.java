package com.data.big.trying.tryingbigdata.controller.request;

import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
public class TemperatureSearchRequest {

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime from;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime to;
    @NotNull
    private SearchOperation searchOperation;
    private String userId;
}
