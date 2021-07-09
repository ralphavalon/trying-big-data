package com.data.big.trying.tryingbigdata.controller.request;

import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Getter
@Setter
@Slf4j
public class SearchRequest {

    @NotNull
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime from;

    @NotNull
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime to;

    @NotNull
    private SearchOperation operation;

    private List<String> type;

}
