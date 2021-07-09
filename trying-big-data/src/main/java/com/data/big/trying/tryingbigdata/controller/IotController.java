package com.data.big.trying.tryingbigdata.controller;

import com.data.big.trying.tryingbigdata.amqp.IotAMQP;
import com.data.big.trying.tryingbigdata.controller.request.AddIotDeviceRequest;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class IotController {

    @Autowired
    private IotAMQP amqpClient;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addTemperature(@Valid @RequestBody AddIotDeviceRequest request) throws Exception {
        amqpClient.send(request.toIotDevice());
    }

}
