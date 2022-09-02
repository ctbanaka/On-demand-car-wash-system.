package com.carwash.carservice.models;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cars")
public class Car {
    @Id
    private int carId;
    @NonNull
    private String userName;
    @NonNull
    private String carBrand;
    @NonNull
    private String model;
    @NonNull
    private String color;

    private String numberPlate;

}