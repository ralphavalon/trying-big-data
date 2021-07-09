package com.data.big.trying.tryingbigdata.repository;

import com.data.big.trying.tryingbigdata.controller.request.SearchRequest;
import java.util.List;
import java.util.function.Consumer;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IotSearchRepository {

    private static final String WHERE_SQL = "FROM iot_device WHERE 1 = 1";
    private static final String AND_DATE_BETWEEN_SQL = "AND created_at BETWEEN :from AND :to";
    private static final String AND_TYPE_IN_SQL = "AND type IN :types";
    private static final String GROUP_BY_SQL = "GROUP BY type";

    @Autowired
    private EntityManager entityManager;

    public void process(String prefixSelectSQL, SearchRequest search,
                        Consumer<Object[]> resultConsumer) {
        Query query = entityManager
            .createNativeQuery(getFullSQL(prefixSelectSQL, search));

        if (search.getFrom() != null && search.getTo() != null) {
            query.setParameter("from", search.getFrom());
            query.setParameter("to", search.getTo());
        }

        if (search.getType() != null && search.getType().size() > 0) {
            query.setParameter("types", search.getType());
        }

        List<Object[]> resultList = query.getResultList();
        resultList.stream().forEach(resultConsumer);
    }

    private String getFullSQL(String prefixSelectSQL, SearchRequest search) {
        String fullSQL = prefixSelectSQL + " " + WHERE_SQL;
        if (search.getFrom() != null && search.getTo() != null) {
            fullSQL += " " + AND_DATE_BETWEEN_SQL;
        }
        if (search.getType() != null && search.getType().size() > 0) {
            fullSQL += " " + AND_TYPE_IN_SQL;
        }
        fullSQL += " " + GROUP_BY_SQL;

        return fullSQL;
    }

}
