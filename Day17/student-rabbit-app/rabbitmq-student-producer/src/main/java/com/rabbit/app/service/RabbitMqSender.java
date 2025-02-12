package com.rabbit.app.service;

import com.rabbit.app.module.Student;
import com.rabbit.app.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {
  private static final Logger logger = LoggerFactory.getLogger(RabbitMqSender.class.getName());
  private final AmqpTemplate amqpTemplate;
  private final StudentRepository studentRepository;
  @Value("${rabbitmq.exchange.name}")
  String exchangeName;

  @Value("${rabbitmq.routingkey.name}")
  String routingKeyName;

  @Value("${rabbitmq.employee.routingkey.name}")
  String studentRoutingKeyName;

  public RabbitMqSender(AmqpTemplate amqpTemplate, StudentRepository studentRepository) {
    this.amqpTemplate = amqpTemplate;
      this.studentRepository = studentRepository;
  }

  public Student saveStudent(Student student) {
    logger.info("saving student: {}", student.toString());
    amqpTemplate.convertAndSend(exchangeName, studentRoutingKeyName, student);
    return (Student) studentRepository.save(student);
  }

  public void deleteStudent(Long id) {
    logger.info("deleting student: {}", id);
    amqpTemplate.convertAndSend(exchangeName, routingKeyName, id);
    studentRepository.deleteById(id);
  }
}
