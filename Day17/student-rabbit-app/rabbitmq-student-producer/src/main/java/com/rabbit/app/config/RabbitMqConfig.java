package com.rabbit.app.config;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

  @Value("${rabbitmq.queue.name}")
  String queueName;
  @Value("${rabbitmq.exchange.name}")
  String exchangeName;
  @Value("${rabbitmq.routingkey.name}")
  String routingKeyName;

  @Value("${rabbitmq.student.queue.name}")
  String studentQueueName;

  @Value("${rabbitmq.student.routingkey.name}")
  String studentRoutingKeyName;

  @Bean
  public Queue queue() {
    return new Queue(queueName, true);
  }

  @Bean
  public Queue studentQueue() {
    return new Queue(studentQueueName, true);
  }

  @Bean
  public DirectExchange exchange() {
    return new DirectExchange(exchangeName);
  }

  @Bean
  public Binding binding(Queue queue, DirectExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(routingKeyName);
  }

  @Bean
  public Binding studentBinding(Queue studentQueue, DirectExchange exchange) {
    return BindingBuilder.bind(studentQueue).to(exchange).with(studentRoutingKeyName);
  }

  @Bean
  public MessageConverter JsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
    final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMandatory(true);
    rabbitTemplate.setMessageConverter(JsonMessageConverter());
    return rabbitTemplate;
  }
}
