package com.carwash.locationservice.service;

import com.carwash.locationservice.exception.LocationNotFoundException;
import com.carwash.locationservice.model.Location;
import com.carwash.locationservice.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class LocationServiceImpl implements LocationService{

    @Autowired
    LocationRepository locationRepository;

    @Override
    public int addLocation(Location location) {
      locationRepository.save(location);
      return location.getLocationId();
    }

    @Override
    public void editLocation(Location locationDto) {

      if(locationRepository.existsById(locationDto.getLocationId())){
            locationRepository.save(locationDto);
      } else {
          throw new LocationNotFoundException("location does not exist");
      }
    }

    @Override
    public void deleteLocation(int locationId) {
        if(locationRepository.existsById(locationId)){
            locationRepository.deleteById(locationId);
        } else {
            throw new LocationNotFoundException("location does not exist");
        }
    }

    @Override
    public Optional<Location> getLocationById(int locationId) {
        Optional<Location> location;
         if(locationRepository.existsById(locationId)){
            location= locationRepository.findById(locationId);
             return location;
         }else{
             throw new LocationNotFoundException("location not found");
         }

    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
