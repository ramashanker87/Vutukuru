package com.revanth.app.service;

import com.revanth.app.Exception.ParkingNotFoundException;
import com.revanth.app.model.ParkingRecord;
import com.revanth.app.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    public void saveRecord(ParkingRecord record) {
        parkingRepository.save(record);
    }

    public void calculatePrice(String regNo) {
        ParkingRecord record = parkingRepository.findByRegNo(regNo)
                .orElseThrow(() -> new ParkingNotFoundException("Parking record not found for: " + regNo));

        record.setEndTime(new Date());
        long duration = record.getEndTime().getTime() - record.getStartTime().getTime();
        int hours = (int) TimeUnit.MILLISECONDS.toHours(duration) + 1;
        record.setPrice(hours * 10); // ₹10 per hour

        parkingRepository.save(record);
    }
}
