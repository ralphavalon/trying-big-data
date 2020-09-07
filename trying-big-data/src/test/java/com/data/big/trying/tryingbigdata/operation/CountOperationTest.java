package com.data.big.trying.tryingbigdata.operation;

import com.data.big.trying.tryingbigdata.controller.request.TemperatureSearchRequest;
import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import com.data.big.trying.tryingbigdata.repository.TemperatureRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CountOperation.class)
public class CountOperationTest {

    @MockBean
    TemperatureRepository repository;

    @Autowired
    CountOperation operation;

    @Test
    public void testCountWithUserId() {
        TemperatureSearchRequest mock = mock(TemperatureSearchRequest.class);
        when(mock.getUserId()).thenReturn("userId");
        when(mock.getFrom()).thenReturn(LocalDateTime.now());
        when(mock.getTo()).thenReturn(LocalDateTime.now().plusSeconds(1));
        when(repository.countByUserIdAndCreatedAtBetween(eq("userId"), any(LocalDateTime.class), any(LocalDateTime.class)))
                .thenReturn(3L);

        Long response = operation.process(mock);

        assertEquals(3L, response);
        verify(repository, times(0)).countByCreatedAtBetween(mock.getFrom(), mock.getTo());
        verify(repository, times(1)).countByUserIdAndCreatedAtBetween(mock.getUserId(), mock.getFrom(), mock.getTo());
    }

    @Test
    public void testCountWithoutUserId() {
        TemperatureSearchRequest mock = mock(TemperatureSearchRequest.class);
        when(mock.getFrom()).thenReturn(LocalDateTime.now());
        when(mock.getTo()).thenReturn(LocalDateTime.now().plusSeconds(1));

        when(repository.countByCreatedAtBetween(any(LocalDateTime.class), any(LocalDateTime.class)))
                .thenReturn(5L);

        Long response = operation.process(mock);

        assertEquals(5L, response);
        verify(repository, times(1)).countByCreatedAtBetween(mock.getFrom(), mock.getTo());
        verify(repository, times(0)).countByUserIdAndCreatedAtBetween(mock.getUserId(), mock.getFrom(), mock.getTo());
    }

    @Test
    public void testSearchOperation() {
        assertEquals(SearchOperation.COUNT, operation.getSearchOperation());
    }

}
