package com.data.big.trying.tryingbigdata.service;

import com.data.big.trying.tryingbigdata.controller.request.TemperatureSearchRequest;
import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import com.data.big.trying.tryingbigdata.operation.Operation;
import org.springframework.stereotype.Component;

@Component
public class MockOperation implements Operation {

    @Override
    public Long process(TemperatureSearchRequest request) {
        return 0L;
    }

    @Override
    public SearchOperation getSearchOperation() {
        return SearchOperation.COUNT;
    }
}
