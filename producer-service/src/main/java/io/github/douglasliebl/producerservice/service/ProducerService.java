package io.github.douglasliebl.producerservice.service;

import io.github.douglasliebl.producerservice.model.Message;

public interface ProducerService {

    void produce(Message message);
}
