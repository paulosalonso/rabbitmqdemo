package com.github.paulosalonso.rabbitmq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@RequiredArgsConstructor
@Component
public class QueryDemoProducer {

    protected static final String EXCHANGE = "demo-exchange";
    protected static final String ROUTING_KEY = "demo-queue";

    private final RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void publish() {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, new DemoDTO("Published by application producer"));
        log.info("Message successfully published. Exchange: {}, Rounting Key: {}", EXCHANGE, ROUTING_KEY);
    }
}
