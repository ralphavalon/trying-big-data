package com.data.big.trying.tryingbigdata.service;

import static org.mockito.Mockito.verify;

import com.data.big.trying.tryingbigdata.domain.IotDevice;
import com.data.big.trying.tryingbigdata.helper.TemperatureHelper;
import com.data.big.trying.tryingbigdata.repository.IotRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { IotService.class })
public class IotServiceTest {

    @Autowired
    IotService service;

    @MockBean
    IotRepository repository;

    @Test
    public void testAddTemperature() {
        IotDevice iotDevice = TemperatureHelper.getTemperaturesEvenSize().get(0);

        service.addTemperature(iotDevice);

        verify(repository).save(iotDevice);
    }

}
