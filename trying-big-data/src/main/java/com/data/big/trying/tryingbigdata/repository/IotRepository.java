package com.data.big.trying.tryingbigdata.repository;

import com.data.big.trying.tryingbigdata.domain.IotDevice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IotRepository extends CrudRepository<IotDevice, Long> {

}
