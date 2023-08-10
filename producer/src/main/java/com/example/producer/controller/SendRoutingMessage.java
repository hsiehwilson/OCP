package com.example.producer.controller;

import com.example.producer.service.SendMailService;
import com.example.producer.service.SenderService;
import com.example.producer.service.routingmode.bean.mailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendRoutingMessage {
    @Autowired
    private SendMailService sendMailService;

    @Autowired
    private SenderService senderService;

    @PostMapping("/sendRoutingMessage")
    public boolean fanout(@RequestBody mailTemplate message) {
        return sendMailService.SendRoutingMessage(message);
    }
}
