package com.data.big.trying.tryingbigdata.service;

import com.data.big.trying.tryingbigdata.domain.IotDevice;
import com.data.big.trying.tryingbigdata.repository.IotRepository;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IotService {

    private IotRepository iotRepository;

    public Map<String, Double> processSearch() {
        return new HashMap<>();
    }

    public void addTemperature(IotDevice iotDevice) {
        iotRepository.save(iotDevice);
    }

}
