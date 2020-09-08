package com.data.big.trying.tryingbigdata.repository;

import com.data.big.trying.tryingbigdata.domain.Temperature;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TemperatureRepository extends MongoRepository<Temperature, String> {

    long countByCreatedAtBetween(Long from, Long to);

    long countByUserIdAndCreatedAtBetween(String userId, Long from, Long to);

    List<Temperature> findAllByCreatedAtBetween(Long from, Long to);

    List<Temperature> findAllByUserIdAndCreatedAtBetween(String userId, Long from, Long to);

}
