package com.data.big.trying.tryingbigdata.service;

import static org.mockito.Mockito.verify;

import com.data.big.trying.tryingbigdata.domain.Temperature;
import com.data.big.trying.tryingbigdata.helper.TemperatureHelper;
import com.data.big.trying.tryingbigdata.repository.TemperatureRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { TemperatureService.class })
public class TemperatureServiceTest {

    @Autowired
    TemperatureService service;

    @MockBean
    TemperatureRepository repository;

    @Test
    public void testAddTemperature() {
        Temperature temperature = TemperatureHelper.getTemperaturesEvenSize().get(0);

        service.addTemperature(temperature);

        verify(repository).save(temperature);
    }

}
