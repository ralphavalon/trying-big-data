package com.data.big.trying.tryingbigdata.controller.request;

import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import com.data.big.trying.tryingbigdata.domain.exception.ValidationException;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {

    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime from;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime to;

    @NotNull
    private SearchOperation operation;

    private List<String> type;

    public void validate() {
        if((from == null && to != null) || (from != null && to == null)) {
            throw new ValidationException("Cannot have 'from' without 'to' and vice versa");
        }

        if(from.isAfter(to)) {
            throw new ValidationException("'from' cannot be greater than 'to'");
        }
    }

}
