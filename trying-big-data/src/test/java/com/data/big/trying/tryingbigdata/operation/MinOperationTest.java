package com.data.big.trying.tryingbigdata.operation;

import com.data.big.trying.tryingbigdata.controller.request.TemperatureSearchRequest;
import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import com.data.big.trying.tryingbigdata.domain.exception.NoDataFound;
import com.data.big.trying.tryingbigdata.repository.TemperatureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static com.data.big.trying.tryingbigdata.helper.TemperatureHelper.getTemperaturesEvenSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MinOperation.class)
public class MinOperationTest {

    @MockBean
    TemperatureRepository repository;

    @Autowired
    MinOperation operation;

    TemperatureSearchRequest mock;

    @BeforeEach
    public void setup() {
        mock = mock(TemperatureSearchRequest.class);
        when(mock.getFrom()).thenReturn(LocalDateTime.now());
        when(mock.getTo()).thenReturn(LocalDateTime.now().plusSeconds(1));
    }

    @Test
    public void testMinWithUserId() {
        when(mock.getUserId()).thenReturn("userId");

        when(repository.findAllByUserIdAndCreatedAtBetween(eq("userId"), any(Long.class), any(Long.class)))
                .thenReturn(getTemperaturesEvenSize());

        Double response = operation.process(mock);

        assertEquals(30L, response);
        verify(repository, times(0)).findAllByCreatedAtBetween(mock.fromAsMillis(), mock.toAsMillis());
        verify(repository, times(1)).findAllByUserIdAndCreatedAtBetween(mock.getUserId(), mock.fromAsMillis(), mock.toAsMillis());
    }

    @Test
    public void testMinWithUserIdWithEmptyList() {
        when(mock.getUserId()).thenReturn("userId");

        when(repository.findAllByUserIdAndCreatedAtBetween(eq("userId"), any(Long.class), any(Long.class)))
                .thenReturn(new ArrayList<>());

        assertThrows(NoDataFound.class, () -> {
            operation.process(mock);
        });

        verify(repository, times(0)).findAllByCreatedAtBetween(mock.fromAsMillis(), mock.toAsMillis());
        verify(repository, times(1)).findAllByUserIdAndCreatedAtBetween(mock.getUserId(), mock.fromAsMillis(), mock.toAsMillis());
    }

    @Test
    public void testMinWithoutUserId() {
        when(repository.findAllByCreatedAtBetween(any(Long.class), any(Long.class)))
                .thenReturn(getTemperaturesEvenSize());

        Double response = operation.process(mock);

        assertEquals(30L, response);
        verify(repository, times(1)).findAllByCreatedAtBetween(mock.fromAsMillis(), mock.toAsMillis());
        verify(repository, times(0)).findAllByUserIdAndCreatedAtBetween(mock.getUserId(), mock.fromAsMillis(), mock.toAsMillis());
    }

    @Test
    public void testMinWithoutUserIdWithEmptyList() {
        when(repository.findAllByUserIdAndCreatedAtBetween(eq("userId"), any(Long.class), any(Long.class)))
                .thenReturn(new ArrayList<>());

        assertThrows(NoDataFound.class, () -> {
            operation.process(mock);
        });

        verify(repository, times(1)).findAllByCreatedAtBetween(mock.fromAsMillis(), mock.toAsMillis());
        verify(repository, times(0)).findAllByUserIdAndCreatedAtBetween(mock.getUserId(), mock.fromAsMillis(), mock.toAsMillis());
    }

    @Test
    public void testSearchOperation() {
        assertEquals(SearchOperation.MIN, operation.getSearchOperation());
    }

}
