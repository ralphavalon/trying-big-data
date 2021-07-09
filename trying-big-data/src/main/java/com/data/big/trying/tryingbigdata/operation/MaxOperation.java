package com.data.big.trying.tryingbigdata.operation;

import com.data.big.trying.tryingbigdata.controller.request.SearchRequest;
import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import com.data.big.trying.tryingbigdata.repository.IotSearchRepository;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaxOperation implements Operation {

    @Autowired
    private IotSearchRepository impl;

    @Override
    public Map<String, BigInteger> process(SearchRequest request) {
        Map<String, BigInteger> result = new HashMap<>();
        impl.process("SELECT type, MAX(value) AS value", request, row -> {
            result.put((String) row[0], (BigInteger) row[1]);
        });
        return result;
    }

    @Override
    public SearchOperation getSearchOperation() {
        return SearchOperation.MAX;
    }
}
