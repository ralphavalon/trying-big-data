package com.data.big.trying.tryingbigdata.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.data.big.trying.tryingbigdata.domain.Temperature;
import com.data.big.trying.tryingbigdata.helper.JsonHelper;
import com.data.big.trying.tryingbigdata.service.TemperatureService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SearchController.class)
public class SearchControllerTest {

    @MockBean
    TemperatureService service;

    @Autowired
    private MockMvc mvc;


    @Test
    public void shouldAddTemperature() throws Exception {
        String request = JsonHelper.loadTemperatureRequest("add");

        mvc.perform(post("/temperature").contentType(MediaType.APPLICATION_JSON_VALUE).content(request))
            .andExpect(status().isAccepted());

        verify(service, times(1)).addTemperature(any(Temperature.class));
    }

}
