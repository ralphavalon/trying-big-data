package com.data.big.trying.tryingbigdata.operation;

import com.data.big.trying.tryingbigdata.controller.request.TemperatureSearchRequest;
import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import com.data.big.trying.tryingbigdata.domain.Temperature;
import com.data.big.trying.tryingbigdata.repository.TemperatureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import static com.data.big.trying.tryingbigdata.helper.TemperatureHelper.getTemperaturesEvenSize;
import static com.data.big.trying.tryingbigdata.helper.TemperatureHelper.getTemperaturesOddSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AverageOperation.class)
public class AverageOperationTest {

    @MockBean
    TemperatureRepository repository;

    @Autowired
    AverageOperation operation;

    TemperatureSearchRequest mock;

    @BeforeEach
    public void setup() {
        mock = mock(TemperatureSearchRequest.class);
        when(mock.getFrom()).thenReturn(LocalDateTime.now());
        when(mock.getTo()).thenReturn(LocalDateTime.now().plusSeconds(1));
    }

    @ParameterizedTest
    @MethodSource("temperaturesSource")
    public void testMedianWithUserId(List<Temperature> temperatures, Double expectedResponse) {
        when(mock.getUserId()).thenReturn("userId");

        when(repository.findAllByUserIdAndCreatedAtBetween(eq("userId"), any(Long.class), any(Long.class)))
                .thenReturn(temperatures);

        Double response = operation.process(mock);

        assertEquals(expectedResponse, response);
        verify(repository, times(0)).findAllByCreatedAtBetween(mock.fromAsMillis(), mock.toAsMillis());
        verify(repository, times(1)).findAllByUserIdAndCreatedAtBetween(mock.getUserId(), mock.fromAsMillis(), mock.toAsMillis());
    }

    @ParameterizedTest
    @MethodSource("temperaturesSource")
    public void testMedianWithoutUserId(List<Temperature> temperatures, Double expectedResponse) {
        when(repository.findAllByCreatedAtBetween(any(Long.class), any(Long.class)))
                .thenReturn(temperatures);

        Double response = operation.process(mock);

        assertEquals(expectedResponse, response);
        verify(repository, times(1)).findAllByCreatedAtBetween(mock.fromAsMillis(), mock.toAsMillis());
        verify(repository, times(0)).findAllByUserIdAndCreatedAtBetween(mock.getUserId(), mock.fromAsMillis(), mock.toAsMillis());
    }

    @Test
    public void testSearchOperation() {
        assertEquals(SearchOperation.AVG, operation.getSearchOperation());
    }

    static Stream<Arguments> temperaturesSource() {
        return Stream.of(
                Arguments.of(getTemperaturesEvenSize(), 35.666666666666664D),
                Arguments.of(getTemperaturesOddSize(), 35.8)
        );
    }

}
