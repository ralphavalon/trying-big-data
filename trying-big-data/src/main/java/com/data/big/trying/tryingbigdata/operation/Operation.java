package com.data.big.trying.tryingbigdata.operation;

import com.data.big.trying.tryingbigdata.controller.request.TemperatureSearchRequest;
import com.data.big.trying.tryingbigdata.domain.SearchOperation;

public interface Operation {

    Long process(TemperatureSearchRequest request);

    SearchOperation getSearchOperation();

}
