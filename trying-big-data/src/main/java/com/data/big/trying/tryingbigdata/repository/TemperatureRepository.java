package com.data.big.trying.tryingbigdata.repository;

import com.data.big.trying.tryingbigdata.domain.Temperature;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TemperatureRepository extends MongoRepository<Temperature, String>{

    long countByCreatedAtBetween(LocalDateTime from, LocalDateTime to);

    List<Temperature> findAllByCreatedAtBetween(LocalDateTime from, LocalDateTime to);

}
