package com.revanth.app.controller;

import com.revanth.app.model.Car;
import com.revanth.app.model.ParkingStart;
import com.revanth.app.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }


    @PostMapping("/start")
    public ParkingStart startParking(@RequestParam String parkingNo, @RequestBody Car car) {
        System.out.println("🚗 Received request to start parking with parkingNo: " + parkingNo);
        return parkingService.startParking(parkingNo, car);
    }

    @PostMapping("/end")
    public int endParking(@RequestParam String regNo) {
        return parkingService.endParking(regNo);
    }
}

