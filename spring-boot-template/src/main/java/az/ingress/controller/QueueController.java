package az.ingress.controller;

import az.ingress.queue.PaymentQueueDto;
import az.ingress.queue.QueueSender;
import az.ingress.service.QueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/queue")
public class QueueController {
    private final QueueService queueService;

    @PostMapping
    public <T> void sendToQueue(@RequestParam String queueName, @RequestBody T data) {
        queueService.sendToQueue(queueName,data);
    }


}
