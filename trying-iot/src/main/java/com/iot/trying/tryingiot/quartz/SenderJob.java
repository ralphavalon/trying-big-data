package com.iot.trying.tryingiot.quartz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iot.trying.tryingiot.client.ApiClient;
import com.iot.trying.tryingiot.model.CarFuelDevice;
import com.iot.trying.tryingiot.model.HeartRateDevice;
import com.iot.trying.tryingiot.model.IotDevice;
import com.iot.trying.tryingiot.model.IotDevice.Type;
import com.iot.trying.tryingiot.model.ThermostatDevice;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SenderJob {

    private String clientId = UUID.randomUUID().toString();

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private ApiClient apiClient;

    @Scheduled(fixedDelayString = "${delay-in-milliseconds}")
    public void execute() throws Exception {
        List<IotDevice> devices = Arrays.asList(getTemperature(), getHeartRate(), getCarFuel());
        for (IotDevice device : devices) {
            String content = mapper.writeValueAsString(device);
            log.info("Publishing message: " + content);
            apiClient.addTemperature(content);
            log.info("Message published");
        }
    }

    private IotDevice getTemperature() {
        return new ThermostatDevice(clientId, LocalDateTime.now());
    }

    private IotDevice getHeartRate() {
        return new HeartRateDevice(clientId, LocalDateTime.now());
    }

    private IotDevice getCarFuel() {
        return new CarFuelDevice(clientId, LocalDateTime.now());
    }

}
