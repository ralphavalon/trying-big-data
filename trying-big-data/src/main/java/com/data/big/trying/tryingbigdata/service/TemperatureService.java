package com.data.big.trying.tryingbigdata.service;

import com.data.big.trying.tryingbigdata.domain.Temperature;
import com.data.big.trying.tryingbigdata.repository.TemperatureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TemperatureService {

    private TemperatureRepository temperatureRepository;

    public void addTemperature(Temperature temperature) {
        temperatureRepository.save(temperature);
    }

}
