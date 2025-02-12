package com.rabbit.app.controller;

import com.rabbit.app.module.Student;
import com.rabbit.app.service.RabbitMqSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class ProducerStudentContoller {
    private static final Logger logger = LoggerFactory.getLogger(ProducerStudentContoller.class.getName());

    private final RabbitMqSender rabbitMqSender;

    public ProducerStudentContoller(RabbitMqSender rabbitMqSender) {
        this.rabbitMqSender = rabbitMqSender;
    }

    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student) {
         rabbitMqSender.saveStudent(student);
        return student;

    }

    @DeleteMapping("/delete")
    public void deleteStudent(@RequestParam Long id) {
        rabbitMqSender.deleteStudent(id);
    }
}
