package com.data.big.trying.tryingbigdata.controller.request;

import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Getter
public class TemperatureSearchRequest {

    @NotNull
    private LocalDateTime from;
    @NotNull
    private LocalDateTime to;
    @NotNull
    private SearchOperation searchOperation;
    private String userId;

    public Long getFromAsMillis() {
        return from.toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    public Long getToAsMillis() {
        return to.toInstant(ZoneOffset.UTC).toEpochMilli();
    }
}
