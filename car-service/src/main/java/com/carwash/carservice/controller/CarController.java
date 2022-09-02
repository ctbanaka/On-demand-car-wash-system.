package com.carwash.carservice.controller;

import com.carwash.carservice.models.Car;
import com.carwash.carservice.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarServiceImpl carService;

    @PostMapping("/addcar")
    public ResponseEntity<String> addCar(@RequestBody Car car){
        carService.addCar(car);
        return new ResponseEntity<>("added car with id "+car.getCarId(), HttpStatus.OK);
    }

}
