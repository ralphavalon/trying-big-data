package com.data.big.trying.tryingbigdata.repository;

import com.data.big.trying.tryingbigdata.domain.IotDevice;
import org.springframework.data.repository.CrudRepository;

public interface IotRepository extends CrudRepository<IotDevice, Long> {

}
