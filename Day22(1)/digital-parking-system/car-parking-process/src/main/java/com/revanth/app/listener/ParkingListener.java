package com.revanth.app.listener;
import com.revanth.app.model.ParkingRecord;
import com.revanth.app.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.*;

import java.util.Date;
import java.util.List;

@Service
public class ParkingListener {

    @Autowired
    private SqsClient sqsClient;

    @Autowired
    private ParkingService parkingService;

    private static final String PARKING_START_QUEUE = "http://localhost:4566/000000000000/parking-start-request";
    private static final String PARKING_END_QUEUE = "http://localhost:4566/000000000000/parking-end-request";

    public void listenToStartQueue() {
        ReceiveMessageRequest request = ReceiveMessageRequest.builder()
                .queueUrl(PARKING_START_QUEUE)
                .maxNumberOfMessages(10)
                .build();
        List<Message> messages = sqsClient.receiveMessage(request).messages();

        for (Message message : messages) {
            String body = message.body();
            String[] data = body.split(",");
            ParkingRecord record = new ParkingRecord(data[0], new Date(), null, data[3], 0);
            parkingService.saveRecord(record);
            sqsClient.deleteMessage(DeleteMessageRequest.builder()
                    .queueUrl(PARKING_START_QUEUE)
                    .receiptHandle(message.receiptHandle())
                    .build());
        }
    }

    public void listenToEndQueue() {
        ReceiveMessageRequest request = ReceiveMessageRequest.builder()
                .queueUrl(PARKING_END_QUEUE)
                .maxNumberOfMessages(10)
                .build();
        List<Message> messages = sqsClient.receiveMessage(request).messages();

        for (Message message : messages) {
            String regNo = message.body();
            parkingService.calculatePrice(regNo);
            sqsClient.deleteMessage(DeleteMessageRequest.builder()
                    .queueUrl(PARKING_END_QUEUE)
                    .receiptHandle(message.receiptHandle())
                    .build());
        }
    }
}
