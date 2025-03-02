package com.revanth.app.repository;


import com.revanth.app.module.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
    Car findByRegistrationNumber(String parkingNumber);
}
