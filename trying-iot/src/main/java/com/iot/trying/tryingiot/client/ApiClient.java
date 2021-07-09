package com.iot.trying.tryingiot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "api-client", url = "${iot-device.url}")
public interface ApiClient {
    @PostMapping("/")
    void addIotDevice(@RequestBody String body);
}
