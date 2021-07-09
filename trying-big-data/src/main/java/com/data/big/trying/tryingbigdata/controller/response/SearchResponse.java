package com.data.big.trying.tryingbigdata.controller.response;

import java.math.BigInteger;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SearchResponse {

    private Map<String, BigInteger> result;

}
