package com.data.big.trying.tryingbigdata.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "temperature")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Temperature {

    private String userId;
    @Field("temperature")
    private Integer value;
    private LocalDateTime createdAt;

}
