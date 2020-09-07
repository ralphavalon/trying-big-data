package com.data.big.trying.tryingbigdata.operation;

import com.data.big.trying.tryingbigdata.controller.request.TemperatureSearchRequest;
import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import com.data.big.trying.tryingbigdata.domain.Temperature;
import com.data.big.trying.tryingbigdata.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaxOperation implements Operation {

    @Autowired
    private TemperatureRepository repository;

    @Override
    public Double process(TemperatureSearchRequest request) {
        List<Temperature> temperatures = null;

        if(request.getUserId() != null) {
            temperatures = repository.findAllByUserIdAndCreatedAtBetween(request.getUserId(), request.getFrom(), request.getTo());
        } else {
            temperatures = repository.findAllByCreatedAtBetween(request.getFrom(), request.getTo());
        }

        return Double.valueOf(temperatures
                .stream().max((t1, t2) -> t1.getValue().compareTo(t2.getValue())).get().getValue());
    }

    @Override
    public SearchOperation getSearchOperation() {
        return SearchOperation.MAX;
    }

}
