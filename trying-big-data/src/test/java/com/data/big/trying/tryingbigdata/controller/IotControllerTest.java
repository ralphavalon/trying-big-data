package com.data.big.trying.tryingbigdata.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.data.big.trying.tryingbigdata.amqp.IotAMQP;
import com.data.big.trying.tryingbigdata.domain.IotDevice;
import com.data.big.trying.tryingbigdata.helper.JsonHelper;
import com.data.big.trying.tryingbigdata.service.IotService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(IotController.class)
public class IotControllerTest {

    @MockBean
    IotService service;

    @MockBean
    IotAMQP amqp;

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldAddIotDevice() throws Exception {
        String request = JsonHelper.loadTemperatureRequest("add");

        mvc.perform(post("/").contentType(MediaType.APPLICATION_JSON_VALUE).content(request))
            .andExpect(status().isAccepted());

        verify(amqp, times(1)).send(any(IotDevice.class));
    }

}
