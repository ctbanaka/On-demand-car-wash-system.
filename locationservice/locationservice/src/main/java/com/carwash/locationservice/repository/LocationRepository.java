package com.carwash.locationservice.repository;

import com.carwash.locationservice.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location,Integer> {

}
