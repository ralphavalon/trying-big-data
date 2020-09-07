package com.data.big.trying.tryingbigdata.operation;

import com.data.big.trying.tryingbigdata.controller.request.TemperatureSearchRequest;
import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import com.data.big.trying.tryingbigdata.repository.TemperatureRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CountOperation.class)
public class CountOperationTest {

    @MockBean
    TemperatureRepository repository;

    @Autowired
    CountOperation operation;

    @Test
    public void testCount() {
        TemperatureSearchRequest mock = mock(TemperatureSearchRequest.class);
        when(mock.getFrom()).thenReturn(LocalDateTime.now());
        when(mock.getTo()).thenReturn(LocalDateTime.now().plusSeconds(1));

        when(repository.countByCreatedAtBetween(any(LocalDateTime.class), any(LocalDateTime.class)))
                .thenReturn(5L);

        Long response = operation.process(mock);

        assertEquals(5L, response);
        verify(repository).countByCreatedAtBetween(mock.getFrom(), mock.getTo());
    }

    @Test
    public void testSearchOperation() {
        assertEquals(SearchOperation.COUNT, operation.getSearchOperation());
    }

}
