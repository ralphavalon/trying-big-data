package com.data.big.trying.tryingbigdata.operation;

import com.data.big.trying.tryingbigdata.controller.request.TemperatureSearchRequest;
import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import com.data.big.trying.tryingbigdata.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountOperation implements Operation {

    @Autowired
    private TemperatureRepository repository;

    @Override
    public Double process(TemperatureSearchRequest request) {
        if(request.getUserId() != null) {
            return Double.valueOf(repository.countByUserIdAndCreatedAtBetween(request.getUserId(), request.fromAsMillis(), request.toAsMillis()));
        } else {
            return Double.valueOf(repository.countByCreatedAtBetween(request.fromAsMillis(), request.toAsMillis()));
        }
    }

    @Override
    public SearchOperation getSearchOperation() {
        return SearchOperation.COUNT;
    }

}
