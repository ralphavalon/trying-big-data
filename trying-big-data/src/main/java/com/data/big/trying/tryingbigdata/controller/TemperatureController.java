package com.data.big.trying.tryingbigdata.controller;

import com.data.big.trying.tryingbigdata.controller.request.TemperatureSearchRequest;
import com.data.big.trying.tryingbigdata.controller.response.TemperatureSearchResponse;
import com.data.big.trying.tryingbigdata.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TemperatureController {

    @Autowired
    private TemperatureService service;

    @PostMapping("/temperature/search")
    public TemperatureSearchResponse search(@Valid @RequestBody TemperatureSearchRequest request) {
        return new TemperatureSearchResponse(service.processSearch(request));
    }

}
