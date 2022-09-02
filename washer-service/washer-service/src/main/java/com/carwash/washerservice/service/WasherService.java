package com.carwash.washerservice.service;

import com.carwash.washerservice.model.Washer;
import com.carwash.washerservice.model.WasherDto;

import java.util.List;
import java.util.Optional;

public interface WasherService {

    Washer createWasher(Washer washer);

    WasherDto gatWasherByUserName(String userName);

    List<WasherDto> getAllWashers();

    String updateUser(Washer washer);

    void deleteUser(String userName);





}
