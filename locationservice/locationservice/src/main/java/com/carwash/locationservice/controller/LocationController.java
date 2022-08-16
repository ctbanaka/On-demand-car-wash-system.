package com.carwash.locationservice.controller;

import com.carwash.locationservice.model.Location;
import com.carwash.locationservice.service.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    LocationServiceImpl locationService;

    @PostMapping("/add")
   public ResponseEntity<String> addLocation(Location location){
      int locationId= locationService.addLocation(location);
       return new ResponseEntity<>("location saved id "+locationId, HttpStatus.OK);
   }
   @PutMapping("/edit")
   public ResponseEntity<String> editLocation(Location location) {
       locationService.editLocation(location);
       return new ResponseEntity<>("edited succesfully",HttpStatus.OK);
   }

   @GetMapping("/{locationId}")
    public ResponseEntity<Optional<Location>> getLocation(int locationId){
        Optional<Location> location=locationService.getLocationById(locationId);
        return new ResponseEntity<>(location,HttpStatus.OK);
   }

   @GetMapping("/all-location")
   public ResponseEntity<List<Location>> getAllLocation(){
      List<Location> locations= locationService.getAllLocations();
       return new ResponseEntity<>(locations,HttpStatus.OK);
   }
   @DeleteMapping("/{locationId}")
   public ResponseEntity<String> deleteLocation(int locationId){
        locationService.deleteLocation(locationId);
        return new ResponseEntity<>("deleted successfully" , HttpStatus.OK);
   }
}
