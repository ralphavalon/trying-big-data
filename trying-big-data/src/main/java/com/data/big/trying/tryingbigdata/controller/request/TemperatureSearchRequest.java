package com.data.big.trying.tryingbigdata.controller.request;

import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Getter
@Slf4j
public class TemperatureSearchRequest {

    @NotNull
    private LocalDateTime from;
    @NotNull
    private LocalDateTime to;
    @NotNull
    private SearchOperation searchOperation;
    private String userId;

    public Long fromAsMillis() {
        long epochMilli = from.toInstant(ZoneOffset.UTC).toEpochMilli();
        log.info("From: {} ; {} ms", from, epochMilli);
        return epochMilli;
    }

    public Long toAsMillis() {
        long epochMilli = to.toInstant(ZoneOffset.UTC).toEpochMilli();
        log.info("To: {} ; {} ms", to, epochMilli);
        return epochMilli;
    }
}
