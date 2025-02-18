package com.vehicle_app.service;

import com.vehicle_app.module.Registration;
import com.vehicle_app.module.Vehicle;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegistrationService {

    private Map<String, Registration> registrationMap = new HashMap<>();

    public void registerVehicle(String vehicleNumber, Registration registration) {
        registrationMap.put(vehicleNumber, registration);
    }

    public void deregisterVehicle(String vehicleNumber) {
        registrationMap.remove(vehicleNumber);
    }
}