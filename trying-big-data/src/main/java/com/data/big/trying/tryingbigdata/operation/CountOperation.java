package com.data.big.trying.tryingbigdata.operation;

import com.data.big.trying.tryingbigdata.controller.request.TemperatureSearchRequest;
import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import com.data.big.trying.tryingbigdata.domain.Temperature;
import com.data.big.trying.tryingbigdata.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountOperation implements Operation {

    @Autowired
    private TemperatureRepository repository;

    @Override
    public Long process(TemperatureSearchRequest request) {
        if(request.getUserId() != null) {
            return repository.countByUserIdAndCreatedAtBetween(request.getUserId(), request.getFrom(), request.getTo());
        } else {
            return repository.countByCreatedAtBetween(request.getFrom(), request.getTo());
        }
    }

    @Override
    public SearchOperation getSearchOperation() {
        return SearchOperation.COUNT;
    }

}
