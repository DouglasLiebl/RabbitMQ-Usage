package io.github.douglasliebl.consumerservice.util.consumers;

import io.github.douglasliebl.consumerservice.model.Message;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class MessageConsumer {

    @RabbitListener(queues = {"product.log"})
    public void consumer(@Payload Message message) {
        log.info("Consumer received message: " + message);
    }

}
