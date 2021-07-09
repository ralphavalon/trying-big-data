package com.data.big.trying.tryingbigdata.service;

import com.data.big.trying.tryingbigdata.config.OperationConfig;
import com.data.big.trying.tryingbigdata.controller.request.AddTemperatureRequest;
import com.data.big.trying.tryingbigdata.controller.request.TemperatureSearchRequest;
import com.data.big.trying.tryingbigdata.domain.Temperature;
import com.data.big.trying.tryingbigdata.operation.Operation;
import com.data.big.trying.tryingbigdata.repository.TemperatureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TemperatureService {

    private TemperatureRepository temperatureRepository;

    public Double processSearch(TemperatureSearchRequest request) {
        Operation processor = OperationConfig.getProcessor(request.getSearchOperation());
        return processor.process(request);
    }

    public void addTemperature(Temperature temperature) {
        temperatureRepository.save(temperature);
    }

}
