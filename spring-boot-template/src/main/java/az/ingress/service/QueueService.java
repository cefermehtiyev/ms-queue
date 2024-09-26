package az.ingress.service;

import az.ingress.queue.PaymentQueueDto;
import az.ingress.queue.QueueSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueueService {
    private final QueueSender<PaymentQueueDto>  paymentQueueDtoQueueSender;


    public  void sendToQueue( PaymentQueueDto data) {
        paymentQueueDtoQueueSender.sendToQueue(data);
    }
}
