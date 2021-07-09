package com.data.big.trying.tryingbigdata.controller;

import com.data.big.trying.tryingbigdata.controller.request.SearchRequest;
import com.data.big.trying.tryingbigdata.controller.response.SearchResponse;
import com.data.big.trying.tryingbigdata.service.IotService;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Autowired
    private IotService service;

    @GetMapping("/search")
    public SearchResponse search(@Valid @NotNull SearchRequest request) {
        request.validate();
        return new SearchResponse(service.processSearch(request));
    }

}
