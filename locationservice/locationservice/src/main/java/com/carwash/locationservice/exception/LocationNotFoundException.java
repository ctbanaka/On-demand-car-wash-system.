package com.carwash.locationservice.exception;

public class LocationNotFoundException extends RuntimeException {

    public LocationNotFoundException(String messege) {
        super(messege);
    }
}
