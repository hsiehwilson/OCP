package com.example.producer.service;

import com.example.producer.config.RoutingModeConfig;
import com.example.producer.service.routingmode.bean.mailTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {

    @Autowired
    RoutingModeConfig routingModeConfig;
//    private RabbitTemplate rabbitTemplate = routingModeConfig.amqpTemplate();
    @Autowired
    RabbitTemplate rabbitTemplate;
    CorrelationData correlationData = new CorrelationData("1000");
    public boolean SendRoutingMessage(mailTemplate messageContent){
        rabbitTemplate.convertAndSend("routing_exchange", "routing_key", messageContent);
        System.out.println(messageContent);
        return true;
    }

}
