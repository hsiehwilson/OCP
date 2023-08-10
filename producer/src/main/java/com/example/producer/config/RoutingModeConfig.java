package com.example.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingModeConfig {
    private MessageConverter messageConverter;
    public static String ROUTING_QUEUE_NAME = "routing_queue";
    public static String LOGGING_QUEUE_NAME = "logging_queue";
    public static String ROUTING_EXCHANGE_NAME = "routing_exchange";
    public static String ROUTING_KEY="routing_key";

    @Bean
    public Queue routingQueue() {
        return new Queue(ROUTING_QUEUE_NAME); }

    @Bean
    public Queue loggingQueue() {
        return new Queue(LOGGING_QUEUE_NAME); }

    @Bean
    public DirectExchange routingExchange() {
        return new DirectExchange(ROUTING_EXCHANGE_NAME); }

    @Bean
    public Binding bindingRoutingMode() {
        return BindingBuilder.bind(routingQueue())
                .to(routingExchange()) .with(ROUTING_KEY);
    }

    @Bean
    public Binding bindingRoutingMode2() {
        return BindingBuilder.bind(loggingQueue())
                .to(routingExchange()) .with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
