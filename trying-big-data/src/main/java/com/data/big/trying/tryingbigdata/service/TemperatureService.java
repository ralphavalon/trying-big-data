package com.data.big.trying.tryingbigdata.service;

import com.data.big.trying.tryingbigdata.config.OperationConfig;
import com.data.big.trying.tryingbigdata.controller.request.TemperatureSearchRequest;
import com.data.big.trying.tryingbigdata.operation.Operation;
import org.springframework.stereotype.Service;

@Service
public class TemperatureService {

    public Long processSearch(TemperatureSearchRequest request) {
        Operation processor = OperationConfig.getProcessor(request.getSearchOperation());
        return processor.process(request);
    }

}
