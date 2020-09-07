package com.data.big.trying.tryingbigdata.operation;

import com.data.big.trying.tryingbigdata.controller.request.TemperatureSearchRequest;
import com.data.big.trying.tryingbigdata.domain.SearchOperation;

public interface Operation {

    Double process(TemperatureSearchRequest request);

    SearchOperation getSearchOperation();

}
