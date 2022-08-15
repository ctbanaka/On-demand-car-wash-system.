package com.carwash.packageservice.repository;

import com.carwash.packageservice.model.AddOn;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddonRepository extends MongoRepository<AddOn,String> {


}
