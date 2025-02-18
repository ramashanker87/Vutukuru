package com.vehicle_app.contoller;

import com.vehicle_app.module.Owner;
import com.vehicle_app.module.Registration;
import com.vehicle_app.module.Vehicle;
import com.vehicle_app.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    private static final Logger logger = LoggerFactory.getLogger("VehicleLogger");
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    public String registerVehicle(@RequestBody Registration registration) {
        registrationService.registerVehicle(registration.getVehicle().getVehicleNumber(),registration);
        logger.info("Vehicle registered with vehicle number"+ registration.getVehicle());

        return "Vehicle registered successfully";
    }

    @DeleteMapping("/deregister")
    public String deregisterVehicle(@RequestParam String vehicleNumber){
        registrationService.deregisterVehicle(vehicleNumber);
        logger.info("Vehicle deregistered with vehicle number:"+ vehicleNumber);
        return "Vehicle De-registered successfully";
    }
}
