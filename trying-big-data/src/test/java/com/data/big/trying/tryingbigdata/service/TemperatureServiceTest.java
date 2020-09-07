package com.data.big.trying.tryingbigdata.service;

import com.data.big.trying.tryingbigdata.config.OperationConfig;
import com.data.big.trying.tryingbigdata.controller.request.TemperatureSearchRequest;
import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { TemperatureService.class, OperationConfig.class, MockOperation.class })
public class TemperatureServiceTest {

    @Autowired
    TemperatureService service;

    @SpyBean
    MockOperation mockOperation;

    @Test
    public void testProcessSearch() {
        TemperatureSearchRequest mock = mock(TemperatureSearchRequest.class);
        when(mock.getSearchOperation()).thenReturn(SearchOperation.COUNT);
        when(mock.getFrom()).thenReturn(LocalDateTime.now());
        when(mock.getTo()).thenReturn(LocalDateTime.now().plusSeconds(1));

        Long response = service.processSearch(mock);

        assertEquals(0L, response);
        verify(mockOperation).process(mock);
    }

}
