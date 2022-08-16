package com.carwash.locationservice.service;

import com.carwash.locationservice.model.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    int addLocation(Location location);
    void editLocation(Location locationdto);
    void deleteLocation(int locationId);
    Optional<Location> getLocationById(int locationId);
    List<Location> getAllLocations();

}
