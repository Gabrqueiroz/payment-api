package com.gabrielqueiroz.payment_api.messaging.consumer;

import com.gabrielqueiroz.payment_api.messaging.config.RabbitConfig;
import com.gabrielqueiroz.payment_api.messaging.event.TransferMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TransferConsumer {

    @RabbitListener(queues = RabbitConfig.TRANSFER_QUEUE)
    public void receive(TransferMessage message) {
        log.info("Mensagem recebida: {}", message);
    }
}

