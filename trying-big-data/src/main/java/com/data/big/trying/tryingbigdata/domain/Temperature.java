package com.data.big.trying.tryingbigdata.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "temperature")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Temperature {

    private String userId;

    private String type;

    private Integer value;

    private LocalDateTime createdAt;

}
