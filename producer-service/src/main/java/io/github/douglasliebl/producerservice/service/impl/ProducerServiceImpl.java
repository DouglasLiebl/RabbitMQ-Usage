package io.github.douglasliebl.producerservice.service.impl;

import io.github.douglasliebl.producerservice.model.Message;
import io.github.douglasliebl.producerservice.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static io.github.douglasliebl.producerservice.configuration.RabbitMQConfig.EXCHANGE_MARKETPLACE;
import static io.github.douglasliebl.producerservice.configuration.RabbitMQConfig.ROUTING_KEY_PRODUCT_LOG;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void produce(Message message) {
        log.info("Received message: " + message.getMessage());
        rabbitTemplate.convertAndSend(EXCHANGE_MARKETPLACE, ROUTING_KEY_PRODUCT_LOG, message.getMessage());
    }
}
