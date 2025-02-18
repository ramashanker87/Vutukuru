package com.vehicle_app.contoller;

import com.vehicle_app.module.Owner;
import com.vehicle_app.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.registry.Registry;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private RegistrationService registrationService;
    private static final Logger logger = LoggerFactory.getLogger("VehicleLogger");

    @GetMapping("/details")
    public String getOwnerDetails(@RequestHeader Owner owner) {
        logger.debug("owner registered with : " + owner);
        return "Owner Registered Successfully";
    }
}
