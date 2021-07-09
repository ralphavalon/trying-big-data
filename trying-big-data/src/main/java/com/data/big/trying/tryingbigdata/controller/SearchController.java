package com.data.big.trying.tryingbigdata.controller;

import com.data.big.trying.tryingbigdata.controller.request.AddIotDeviceRequest;
import com.data.big.trying.tryingbigdata.controller.response.SearchResponse;
import com.data.big.trying.tryingbigdata.service.IotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SearchController {

    @Autowired
    private IotService service;

    @GetMapping("/search")
    public SearchResponse search() {
        return new SearchResponse(service.processSearch());
    }

    @PostMapping("/temperature")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addTemperature(@Valid @RequestBody AddIotDeviceRequest request) {
        service.addTemperature(request.toIotDevice());
    }

}
