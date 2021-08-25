package com.github.paulosalonso.rabbitmq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class QueryDemoProducer {

    protected static final String EXCHANGE = "paulosalonso";
    protected static final String ROUTING_KEY = "demo";

    private final RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void publish() {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, new DemoDTO("Published by application producer"));
    }
}
