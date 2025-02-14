package com.revanth.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revanth.app.module.Patient;
import com.revanth.app.service.DoctorSqsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.sqs.model.MessageAttributeValue;
import software.amazon.awssdk.utils.Pair;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
public class DoctorController {
    private final DoctorSqsService doctorSqsService;
    @Value("${amazon.aws.sqs.queue}")
    private String queue;

    public DoctorController(DoctorSqsService doctorSqsService) {
        this.doctorSqsService = doctorSqsService;
    }


    @GetMapping("/receive")
    public ResponseEntity<Patient> receive() throws ExecutionException, JsonProcessingException, InterruptedException {
        Pair<Patient, Map<String, MessageAttributeValue>> message= doctorSqsService.consumeMessage(queue,Patient.class);
        Patient patient= message.left();
        Map<String, MessageAttributeValue> messageAttributes = message.right();
        HttpHeaders headers = new HttpHeaders();
        messageAttributes.forEach((key,value)->{
            if(value.stringValue()!=null){
                headers.add(key,value.stringValue());
            }
        });
        return new ResponseEntity<>(patient,headers, HttpStatus.ACCEPTED);

    }
}

