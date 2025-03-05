package com.rabbit.app.controller;

import com.rabbit.app.Employee;
import com.rabbit.app.service.RabbitMqSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
  private static final Logger logger = LoggerFactory.getLogger(ProducerController.class.getName());
  private final RabbitMqSender rabbitMqSender;

  public ProducerController(RabbitMqSender rabbitMqSender) {
    this.rabbitMqSender = rabbitMqSender;
  }

  @GetMapping("/send")
  public String send(@RequestParam("msg") String message) {
    logger.info("send message: {}", message);
    rabbitMqSender.send(message);
    return message;
  }

  @PostMapping("/employee")
  public Employee employee(@RequestBody Employee employee) {
    rabbitMqSender.sendEmployee(employee);
    return employee;
  }
}
