package com.data.big.trying.tryingbigdata.operation;

import com.data.big.trying.tryingbigdata.controller.request.TemperatureSearchRequest;
import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import com.data.big.trying.tryingbigdata.domain.Temperature;
import com.data.big.trying.tryingbigdata.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class MedianOperation implements Operation {

    @Autowired
    private TemperatureRepository repository;

    @Override
    public Long process(TemperatureSearchRequest request) {
        List<Temperature> temperatures = null;

        if(request.getUserId() != null) {
            temperatures = repository.findAllByUserIdAndCreatedAtBetween(request.getUserId(), request.getFrom(), request.getTo());
        } else {
            temperatures = repository.findAllByCreatedAtBetween(request.getFrom(), request.getTo());
        }

        IntStream intStream = temperatures
                .stream()
                .mapToInt(Temperature::getValue)
                .sorted();

        if(temperatures.size() % 2 == 0) {
            return (long) intStream.skip(temperatures.size()/2-1).limit(2).average().getAsDouble();
        }

        return (long) intStream.skip(temperatures.size()/2).findFirst().getAsInt();
    }

    @Override
    public SearchOperation getSearchOperation() {
        return SearchOperation.MEDIAN;
    }

}
