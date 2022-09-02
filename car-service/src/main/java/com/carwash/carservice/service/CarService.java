package com.carwash.carservice.service;

import com.carwash.carservice.models.Car;

import java.util.List;

public interface CarService {

    Car addCar(Car car);
    Car updateCarDetails(Car car);
    Car getCarDetails(String userName);
    List<Car> getYourCars(String userName);
}
