package com.data.big.trying.tryingbigdata.controller;

import com.data.big.trying.tryingbigdata.controller.request.TemperatureSearchRequest;
import com.data.big.trying.tryingbigdata.domain.SearchOperation;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TemperatureController.class)
public class TemperatureControllerTest {

    @MockBean
    TemperatureService service;

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldSearchTemperature() throws Exception {
        when(service.processSearch(any(TemperatureSearchRequest.class))).thenReturn(4D);
        String request = JsonHelper.loadTemperatureRequest("search");
        String response = JsonHelper.loadTemperatureResponse("search");

        mvc.perform(post("/temperature/search").contentType(MediaType.APPLICATION_JSON_VALUE).content(request)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().json(response));

        verify(service, times(1)).processSearch(any(TemperatureSearchRequest.class));
    }

    @Test
    public void shouldAddTemperature() throws Exception {
        String request = JsonHelper.loadTemperatureRequest("add");

        mvc.perform(post("/temperature").contentType(MediaType.APPLICATION_JSON_VALUE).content(request))
            .andExpect(status().isAccepted());

        verify(service, times(1)).addTemperature(any(Temperature.class));
    }

}
