package com.carwash.packageservice.service;

import com.carwash.packageservice.model.AddOn;

import java.util.List;

public interface AddOnService {

    AddOn createAddOn(AddOn addOn);
    AddOn updateAddon(String addOnName);
    List<AddOn>  getAddonList();
    AddOn getAddOnByName(String addOnName);
    String deleteAddOn(String addOnName);
}
