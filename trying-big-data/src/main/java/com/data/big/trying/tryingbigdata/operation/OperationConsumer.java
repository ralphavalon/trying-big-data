package com.data.big.trying.tryingbigdata.operation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.function.Consumer;

public class OperationConsumer {

    public static Consumer<Object[]> typeAndValue(Map<String, BigDecimal> result) {
        return row -> {
            if(row[1] instanceof BigInteger) {
                result.put((String) row[0], new BigDecimal((BigInteger) row[1]));
            } else if(row[1] instanceof Double) {
                result.put((String) row[0], BigDecimal.valueOf((Double) row[1]));
            } else {
                result.put((String) row[0], (BigDecimal) row[1]);
            }
        };
    }
}
