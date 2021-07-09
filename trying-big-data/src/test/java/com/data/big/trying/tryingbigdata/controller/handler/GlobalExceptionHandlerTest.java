//package com.data.big.trying.tryingbigdata.controller.handler;
//
//import com.data.big.trying.tryingbigdata.controller.SearchController;
//import com.data.big.trying.tryingbigdata.controller.request.TemperatureSearchRequest;
//import com.data.big.trying.tryingbigdata.domain.exception.NoDataFound;
//import com.data.big.trying.tryingbigdata.helper.JsonHelper;
//import com.data.big.trying.tryingbigdata.service.TemperatureService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(SearchController.class)
//public class GlobalExceptionHandlerTest {
//
//    @MockBean
//    TemperatureService service;
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Test
//    public void shouldReturnRightMessageWhenNoDataFound() throws Exception {
//        when(service.addTemperature(any(Temperature.class));).thenThrow(new NoDataFound());
//        String request = JsonHelper.loadTemperatureRequest("search");
//        String response = JsonHelper.loadTemperatureResponse("no_data_found");
//
//        mvc.perform(post("/temperature/search").contentType(MediaType.APPLICATION_JSON_VALUE).content(request)
//                .accept(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isNotFound())
//                .andExpect(content().json(response));
//    }
//
//}
