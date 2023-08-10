package com.example.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    @Bean
    public Declarables fanoutBindings() {
        Queue emailQueue = new Queue("email.queue");
        FanoutExchange exchange = new FanoutExchange("fanout");

        return new Declarables(
                emailQueue,
                exchange,
                BindingBuilder.bind(emailQueue).to(exchange)
        );
    }
}
