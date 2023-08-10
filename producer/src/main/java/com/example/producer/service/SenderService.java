package com.example.producer.service;

import com.example.producer.service.routingmode.bean.mailTemplate;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderService {

    @Autowired
    private Declarables declarables;

    @Autowired
    private RabbitTemplate template;

    public String send(mailTemplate message) {
        this.template.convertAndSend(
                declarables.getDeclarablesByType(Exchange.class).get(0).getName(), "", message);
        return "sender sent!";
    }
}
