package com.data.big.trying.tryingbigdata.operation;

import com.data.big.trying.tryingbigdata.controller.request.SearchRequest;
import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

public interface Operation {

    Map<String, BigDecimal> process(SearchRequest request);

    SearchOperation getSearchOperation();

}
