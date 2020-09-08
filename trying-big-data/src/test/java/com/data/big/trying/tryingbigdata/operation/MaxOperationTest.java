package com.data.big.trying.tryingbigdata.operation;

import com.data.big.trying.tryingbigdata.controller.request.TemperatureSearchRequest;
import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import com.data.big.trying.tryingbigdata.repository.TemperatureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static com.data.big.trying.tryingbigdata.helper.TemperatureHelper.getTemperaturesEvenSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MaxOperation.class)
public class MaxOperationTest {

    @MockBean
    TemperatureRepository repository;

    @Autowired
    MaxOperation operation;

    TemperatureSearchRequest mock;

    @BeforeEach
    public void setup() {
        mock = mock(TemperatureSearchRequest.class);
        when(mock.getFrom()).thenReturn(LocalDateTime.now());
        when(mock.getTo()).thenReturn(LocalDateTime.now().plusSeconds(1));
    }

    @Test
    public void testMaxWithUserId() {
        when(mock.getUserId()).thenReturn("userId");

        when(repository.findAllByUserIdAndCreatedAtBetween(eq("userId"), any(Long.class), any(Long.class)))
                .thenReturn(getTemperaturesEvenSize());

        Double response = operation.process(mock);

        assertEquals(40L, response);
        verify(repository, times(0)).findAllByCreatedAtBetween(mock.getFromAsMillis(), mock.getToAsMillis());
        verify(repository, times(1)).findAllByUserIdAndCreatedAtBetween(mock.getUserId(), mock.getFromAsMillis(), mock.getToAsMillis());
    }

    @Test
    public void testMaxWithoutUserId() {
        when(repository.findAllByCreatedAtBetween(any(Long.class), any(Long.class)))
                .thenReturn(getTemperaturesEvenSize());

        Double response = operation.process(mock);

        assertEquals(40L, response);
        verify(repository, times(1)).findAllByCreatedAtBetween(mock.getFromAsMillis(), mock.getToAsMillis());
        verify(repository, times(0)).findAllByUserIdAndCreatedAtBetween(mock.getUserId(), mock.getFromAsMillis(), mock.getToAsMillis());
    }

    @Test
    public void testSearchOperation() {
        assertEquals(SearchOperation.MAX, operation.getSearchOperation());
    }

}
