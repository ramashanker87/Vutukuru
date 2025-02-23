package com.revanth.app.service;

import com.revanth.app.model.Car;
import com.revanth.app.model.ParkingStart;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class ParkingService {

    private final SqsService sqsService;
    private final DynamoDbService dynamoDbService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ParkingService(SqsService sqsService, DynamoDbService dynamoDbService) {
        this.sqsService = sqsService;
        this.dynamoDbService = dynamoDbService;
    }

    public ParkingStart startParking(String regNo, Car car) {
        long startTime = new Date().getTime();
        String parkingNo = UUID.randomUUID().toString(); // Generate unique parking number

        dynamoDbService.saveParkingRecord(regNo, parkingNo, startTime);

        try {
            String message = objectMapper.writeValueAsString(Map.of(
                    "regNo", regNo,
                    "parkingNo", parkingNo,
                    "startTime", startTime
            ));
            sqsService.sendMessage("parking-start-request", message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error while creating JSON message", e);
        }
        return null;
    }

    public int endParking(String regNo) {
        Map<String, AttributeValue> record = dynamoDbService.getParkingRecord(regNo);

        if (record == null || record.isEmpty()) {
            throw new RuntimeException("Parking record not found for regNo: " + regNo);
        }

        long startTime = Long.parseLong(record.get("startTime").s()); // Assuming it's stored as String
        long endTime = new Date().getTime();
        int price = (int) ((endTime - startTime) / 60000) * 2;

        try {
            String message = objectMapper.writeValueAsString(Map.of(
                    "regNo", regNo,
                    "startTime", startTime,
                    "endTime", endTime,
                    "price", price
            ));
            sqsService.sendMessage("parking-end-request", message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error while creating JSON message", e);
        }

        return price;
    }
}

