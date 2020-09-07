package com.data.big.trying.tryingbigdata.operation;

import com.data.big.trying.tryingbigdata.controller.request.TemperatureSearchRequest;
import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import com.data.big.trying.tryingbigdata.domain.Temperature;
import com.data.big.trying.tryingbigdata.repository.TemperatureRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MaxOperation.class)
public class MaxOperationTest {

    @MockBean
    TemperatureRepository repository;

    @Autowired
    MaxOperation operation;

    @Test
    public void testMaxWithUserId() {
        TemperatureSearchRequest mock = mock(TemperatureSearchRequest.class);
        when(mock.getUserId()).thenReturn("userId");
        when(mock.getFrom()).thenReturn(LocalDateTime.now());
        when(mock.getTo()).thenReturn(LocalDateTime.now().plusSeconds(1));

        when(repository.findAllByUserIdAndCreatedAtBetween(eq("userId"), any(LocalDateTime.class), any(LocalDateTime.class)))
                .thenReturn(getTemperatures());

        Long response = operation.process(mock);

        assertEquals(40L, response);
        verify(repository, times(0)).findAllByCreatedAtBetween(mock.getFrom(), mock.getTo());
        verify(repository, times(1)).findAllByUserIdAndCreatedAtBetween(mock.getUserId(), mock.getFrom(), mock.getTo());
    }

    @Test
    public void testMaxWithoutUserId() {
        TemperatureSearchRequest mock = mock(TemperatureSearchRequest.class);
        when(mock.getFrom()).thenReturn(LocalDateTime.now());
        when(mock.getTo()).thenReturn(LocalDateTime.now().plusSeconds(1));

        when(repository.findAllByCreatedAtBetween(any(LocalDateTime.class), any(LocalDateTime.class)))
                .thenReturn(getTemperatures());

        Long response = operation.process(mock);

        assertEquals(40L, response);
        verify(repository, times(1)).findAllByCreatedAtBetween(mock.getFrom(), mock.getTo());
        verify(repository, times(0)).findAllByUserIdAndCreatedAtBetween(mock.getUserId(), mock.getFrom(), mock.getTo());
    }

    @Test
    public void testSearchOperation() {
        assertEquals(SearchOperation.MAX, operation.getSearchOperation());
    }

    private List<Temperature> getTemperatures() {
        return Arrays.asList(
                temperature(30),
                temperature(35),
                temperature(33),
                temperature(40),
                temperature(37),
                temperature(39)
        );
    }

    private Temperature temperature(Integer value) {
        return new Temperature("userId", value, LocalDateTime.now());
    }

}
