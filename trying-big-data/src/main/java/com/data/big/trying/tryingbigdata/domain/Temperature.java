package com.data.big.trying.tryingbigdata.domain;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

//@Document(collection = "temperature")
@Document(collection = "mycollection")
@Getter
public class Temperature {

    private String userId;
    @Field("temperature")
    private Integer value;
    private LocalDateTime createdAt;

}
