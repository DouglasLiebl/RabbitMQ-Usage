package io.github.douglasliebl.producerservice.resource;

import io.github.douglasliebl.producerservice.model.Message;
import io.github.douglasliebl.producerservice.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/producer")
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerService service;

    @PostMapping
    public ResponseEntity produceMessage(@RequestBody Message message) {
        service.produce(message);
        return ResponseEntity.ok().body("Sending message");
    }

}
