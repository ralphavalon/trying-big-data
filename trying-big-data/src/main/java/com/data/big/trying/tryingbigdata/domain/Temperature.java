package com.data.big.trying.tryingbigdata.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "temperature")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Temperature {

    private String userId;
    @Field("temperature")
    private Integer value;

    private String scale;

    private Long createdAt;

}
