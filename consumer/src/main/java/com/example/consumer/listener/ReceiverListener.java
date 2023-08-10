package com.example.consumer.listener;

import com.example.consumer.dto.mailTemplate;
import com.example.consumer.service.EmailSenderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class ReceiverListener {

    @Autowired
    EmailSenderService emailSenderService;

//    @RabbitListener(queues = "email.queue")
//    public void receiveToEmail(String  message) throws MessagingException {
//
//        System.out.println("email.queue: " + message);
//    }

    @RabbitListener(queues = "routing_queue")
    public void receive(@Payload mailTemplate message) throws MessagingException {
        emailSenderService.sendHtmlMessageTest(message);
        System.out.println("寄信成功");
    }

    @RabbitListener(queues = "logging_queue")
    public void receive2(@Payload mailTemplate message) throws MessagingException {
        System.out.println("完成\n"+ message);
    }
}
