package com.data.big.trying.tryingbigdata.operation;

import com.data.big.trying.tryingbigdata.controller.request.TemperatureSearchRequest;
import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import com.data.big.trying.tryingbigdata.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class CountOperation implements Operation {

    @Autowired
    private TemperatureRepository repository;

    @Override
    public Double process(TemperatureSearchRequest request) {
        if(request.getUserId() != null) {
            return Double.valueOf(repository.countByUserIdAndCreatedAtBetween(request.getUserId(), request.getFromAsMillis(), request.getToAsMillis()));
        } else {
            return Double.valueOf(repository.countByCreatedAtBetween(request.getFromAsMillis(), request.getToAsMillis()));
        }
    }

    @Override
    public SearchOperation getSearchOperation() {
        return SearchOperation.COUNT;
    }

}
