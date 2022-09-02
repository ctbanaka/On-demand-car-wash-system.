package com.carwash.carservice.repository;

import com.carwash.carservice.models.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car,Integer> {



}
