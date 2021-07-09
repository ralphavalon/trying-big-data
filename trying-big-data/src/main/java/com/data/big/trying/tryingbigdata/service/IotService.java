package com.data.big.trying.tryingbigdata.service;

import com.data.big.trying.tryingbigdata.controller.request.SearchRequest;
import com.data.big.trying.tryingbigdata.domain.IotDevice;
import com.data.big.trying.tryingbigdata.operation.MaxOperation;
import com.data.big.trying.tryingbigdata.operation.Operation;
import com.data.big.trying.tryingbigdata.repository.IotRepository;
import java.math.BigInteger;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IotService {

    @Autowired
    private IotRepository iotRepository;

    @Autowired
    private Operation operation;

    public Map<String, BigInteger> processSearch(SearchRequest searchRequest) {
        return operation.process(searchRequest);
    }

    public void addIotDevice(IotDevice iotDevice) {
        iotRepository.save(iotDevice);
    }

}
