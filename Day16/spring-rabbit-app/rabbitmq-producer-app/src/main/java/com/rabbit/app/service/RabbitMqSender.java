package com.rabbit.app.service;

import com.rabbit.app.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {
  private static final Logger logger = LoggerFactory.getLogger(RabbitMqSender.class.getName());
  private final AmqpTemplate amqpTemplate;
  @Value("${rabbitmq.exchange.name}")
  String exchangeName;

  @Value("${rabbitmq.routingkey.name}")
  String routingKeyName;

  @Value("${rabbitmq.employee.routingkey.name}")
  String employeeRoutingKeyName;

  public RabbitMqSender(AmqpTemplate amqpTemplate) {
    this.amqpTemplate = amqpTemplate;
  }

  public void send(String message) {
    logger.info("sending message: {}", message);
    amqpTemplate.convertAndSend(exchangeName, routingKeyName, message);
  }

  public void sendEmployee(Employee employee) {
    logger.info("sending employee: {}", employee.toString());
    amqpTemplate.convertAndSend(exchangeName, employeeRoutingKeyName, employee);
  }
}
