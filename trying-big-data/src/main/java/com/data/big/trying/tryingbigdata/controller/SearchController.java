package com.data.big.trying.tryingbigdata.controller;

import com.data.big.trying.tryingbigdata.controller.request.AddTemperatureRequest;
import com.data.big.trying.tryingbigdata.controller.request.TemperatureSearchRequest;
import com.data.big.trying.tryingbigdata.controller.response.SearchResponse;
import com.data.big.trying.tryingbigdata.controller.response.TemperatureSearchResponse;
import com.data.big.trying.tryingbigdata.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SearchController {

    @Autowired
    private TemperatureService service;

    @PostMapping("/search")
    public SearchResponse search(@Valid @RequestBody TemperatureSearchRequest request) {
        return null;
//        return new SearchResponse(service.processSearch(request));
    }

    @PostMapping("/temperature")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addTemperature(@Valid @RequestBody AddTemperatureRequest request) {
        service.addTemperature(request.toTemperature());
    }

}
