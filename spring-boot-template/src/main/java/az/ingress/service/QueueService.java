package az.ingress.service;

import az.ingress.queue.QueueSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueueService {
    private final QueueSender queueSender;


    public <T> void sendToQueue(String queueName, T data) {
        queueSender.sendMessagePayment(queueName,data);
    }
}
