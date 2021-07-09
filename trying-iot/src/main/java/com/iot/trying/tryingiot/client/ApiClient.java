package com.iot.trying.tryingiot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "api-client", url = "${temperature.url}")
public interface ApiClient {
    @PostMapping("/temperature")
    void addTemperature(@RequestBody String body);
}
