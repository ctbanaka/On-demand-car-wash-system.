package com.carwash.locationservice.model;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    private int locationId;
    @NonNull
    private String userName;
    @NonNull
    private String street;
    @NonNull
    private String city;
    @NonNull
    private int pincode;
    @NonNull
    private String state;


}
