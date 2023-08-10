package com.example.consumer.service;

import com.example.consumer.dto.mailTemplate;
import com.example.consumer.model.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmailSenderService {
    private final JavaMailSender emailSender;
    private final SpringTemplateEngine templateEngine;

    public void sendHtmlMessageTest(mailTemplate message) throws javax.mail.MessagingException {
        Email email = new Email();
        email.setTo(message.getTo());
        email.setFrom(message.getFrom());
        email.setSubject(message.getSubject());
        email.setTemplate("email.html");
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", message.getName());
        properties.put("subscriptionDate", message.getSubscriptionDate());
        // properties.put("subscriptionDate", LocalDate.now());
        properties.put("technologies", message.getTechnologies());
        email.setProperties(properties);

        sendHtmlMessage(email);
    }
    public void sendHtmlMessage(Email email) throws javax.mail.MessagingException {
        System.out.println("開始寄信");
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        Context context = new Context();
        context.setVariables(email.getProperties());
        helper.setFrom(email.getFrom());
        helper.setTo(email.getTo());
        helper.setSubject(email.getSubject());
        String html = templateEngine.process(email.getTemplate(), context);
        helper.setText(html, true);
        emailSender.send(message);
    }
}
