package com.rabbit.app.consumer;

import com.rabbit.app.module.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;

public class RabbitMqStudentConsumer {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMqStudentConsumer.class.getName());

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @RabbitListener(queues= "id.out")
    public void receive(Long id) {
        logger.info("delete student: {}", id);
    }

    @RabbitListener(queues= "student.out")
    public void receiveStudent(Student student) {
        logger.info("saving student: {}", student.toString());
    }
}
