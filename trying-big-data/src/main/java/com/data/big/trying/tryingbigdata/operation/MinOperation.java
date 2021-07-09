package com.data.big.trying.tryingbigdata.operation;

import static com.data.big.trying.tryingbigdata.operation.OperationConsumer.typeAndValue;

import com.data.big.trying.tryingbigdata.controller.request.SearchRequest;
import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import com.data.big.trying.tryingbigdata.repository.IotSearchRepository;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MinOperation implements Operation {

    @Autowired
    private IotSearchRepository searchRepository;

    @Override
    public Map<String, BigDecimal> process(SearchRequest request) {
        Map<String, BigDecimal> result = new HashMap<>();
        searchRepository.process("SELECT type, MIN(value) AS value", request, typeAndValue(result));
        return result;
    }

    @Override
    public SearchOperation getSearchOperation() {
        return SearchOperation.MIN;
    }
}
