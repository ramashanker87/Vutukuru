package com.revanth.app;

import com.revanth.app.controller.ParkingController;
import com.revanth.app.service.ParkingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.revanth.app.config"

})
public class DigitalParkingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalParkingSystemApplication.class, args);
	}

}
