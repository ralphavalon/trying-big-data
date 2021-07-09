package com.data.big.trying.tryingbigdata.config;

import com.data.big.trying.tryingbigdata.domain.SearchOperation;
import com.data.big.trying.tryingbigdata.operation.Operation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OperationConfig {

    @Autowired
    private List<Operation> operations;

    private static Map<SearchOperation, Operation> operationMap = new HashMap<>();

    @PostConstruct
    private void config() {
        for(Operation operation : operations) {
            operationMap.put(operation.getSearchOperation(), operation);
        }
    }

    public static Operation getProcessor(SearchOperation searchOperation) {
        return operationMap.get(searchOperation);
    }
}
