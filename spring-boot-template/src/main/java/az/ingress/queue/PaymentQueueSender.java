package az.ingress.queue;

import az.ingress.configuration.QueueProperties;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import static az.ingress.mapper.factory.ObjectMapperFactory.OBJECT_MAPPER_FACTORY;

@Component
@RequiredArgsConstructor
public class PaymentQueueSender implements QueueSender<PaymentQueueDto> {
    private final AmqpTemplate amqpTemplate;
    private final QueueProperties queueProperties;

    @Override
    @SneakyThrows
    public void sendToQueue(PaymentQueueDto payment) {
        String queue = queueProperties.getPaymentQ();
        amqpTemplate.convertAndSend(queue,OBJECT_MAPPER_FACTORY.createObjectMapper().writeValueAsString(payment));

    }
}
