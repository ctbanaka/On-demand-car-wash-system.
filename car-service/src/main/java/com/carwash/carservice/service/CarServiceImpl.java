package com.carwash.carservice.service;


import com.carwash.carservice.exceptions.UserNameException;
import com.carwash.carservice.models.Car;
import com.carwash.carservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CarServiceImpl implements CarService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CarRepository carRepository;



    @Override
    public Car addCar(Car car) {
        boolean value=false;
      value =  restTemplate.getForObject("http://localhost:8081/users/exist/"+car.getUserName(),Boolean.class);

      if(!value)
          throw new UserNameException("incorrect username");
        Car car1 = carRepository.save(car);
         return car1 ;
    }

    @Override
    public Car updateCarDetails(Car car) {
        return null;
    }

    @Override
    public Car getCarDetails(String userName) {
        return null;
    }

    @Override
    public List<Car> getYourCars(String userName) {
        return null;
    }
}
