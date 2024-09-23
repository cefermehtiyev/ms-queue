package az.ingress.queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import static az.ingress.mapper.factory.ObjectMapperFactory.OBJECT_MAPPER_FACTORY;

@Component
@RequiredArgsConstructor
public class QueueSender {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public <T> void sendMessagePayment(String queueName, T payment){
        amqpTemplate.convertAndSend(queueName,objectMapper.writeValueAsString(payment));

    }

}
