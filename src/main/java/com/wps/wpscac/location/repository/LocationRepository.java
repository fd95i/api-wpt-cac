package com.wps.wpscac.location.repository;

import com.wps.wpscac.location.entity.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, String> {
}
