package com.revanth.app.service;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.HashMap;
import java.util.Map;

@Service
public class DynamoDbService {

    private final DynamoDbClient dynamoDbClient;

    public DynamoDbService(DynamoDbClient dynamoDbClient) {
        this.dynamoDbClient = dynamoDbClient;
    }

    private static final String TABLE_NAME = "ParkingRecords";

    public void saveParkingRecord(String regNo, String parkingNo, long startTime) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("regNo", AttributeValue.builder().s(regNo).build());
        item.put("parkingNo", AttributeValue.builder().s(parkingNo).build());
        item.put("startTime", AttributeValue.builder().n(String.valueOf(startTime)).build());

        PutItemRequest request = PutItemRequest.builder()
                .tableName(TABLE_NAME)
                .item(item)
                .build();

        dynamoDbClient.putItem(request);
    }

    public Map<String, AttributeValue> getParkingRecord(String regNo) {
        GetItemRequest request = GetItemRequest.builder()
                .tableName(TABLE_NAME)
                .key(Map.of("regNo", AttributeValue.builder().s(regNo).build()))
                .build();

        return dynamoDbClient.getItem(request).item();
    }
}
