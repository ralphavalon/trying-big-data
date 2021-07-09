package com.data.big.trying.tryingbigdata.repository;

import com.data.big.trying.tryingbigdata.domain.IotDevice;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IotRepository extends JpaRepository<IotDevice, String> {

    long countByCreatedAtBetween(LocalDateTime from, LocalDateTime to);

    long countByUserIdAndCreatedAtBetween(String userId, LocalDateTime from, LocalDateTime to);

    List<IotDevice> findAllByCreatedAtBetween(LocalDateTime from, LocalDateTime to);

    List<IotDevice> findAllByUserIdAndCreatedAtBetween(String userId, LocalDateTime from, LocalDateTime to);

}
