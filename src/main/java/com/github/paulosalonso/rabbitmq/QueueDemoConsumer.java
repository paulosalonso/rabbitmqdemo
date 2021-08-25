package com.github.paulosalonso.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QueueDemoConsumer {

  @RabbitListener(queues = "${spring.rabbitmq.queue.demo}", messageConverter = "jsonMessageConverter")
  public void listen(final DemoDTO message) {
    log.info("Consuming message from queue message {}", message);
  }
}
