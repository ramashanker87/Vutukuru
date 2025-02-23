package com.revanth.app.repository;

import com.revanth.app.model.ParkingRecord;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;

import java.util.Optional;

@Repository
public class ParkingRepository {

    private final DynamoDbTable<ParkingRecord> table;

    public ParkingRepository(DynamoDbEnhancedClient enhancedClient) {
        this.table = enhancedClient.table("ParkingRecords", TableSchema.fromBean(ParkingRecord.class));
    }

    public void save(ParkingRecord record) {
        table.putItem(record);
    }

    public Optional<ParkingRecord> findByRegNo(String regNo) {
        return table.query(r -> r.queryConditional(QueryConditional.keyEqualTo(k -> k.partitionValue(regNo))))
                .items().stream().findFirst();
    }
}

