package com.gabrielqueiroz.payment_api.messaging.config;

import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String TRANSFER_QUEUE = "transfer.queue";
    public static final String TRANSFER_EXCHANGE = "transfer.exchange";
    public static final String TRANSFER_ROUTING_KEY = "transfer.routing";

    @Bean
    public Queue queue() {
        return new Queue(TRANSFER_QUEUE, true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(TRANSFER_EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(TRANSFER_ROUTING_KEY);
    }

    @Autowired
    private RabbitTemplate rabbitTemplate; // injetando RabbitTemplate

    @PostConstruct
    public void init() {
        System.out.println("RabbitConfig carregado!");

        // envio de teste
        rabbitTemplate.convertAndSend(
                TRANSFER_EXCHANGE,
                TRANSFER_ROUTING_KEY,
                "Mensagem de teste"
        );
        System.out.println("Mensagem de teste enviada para RabbitMQ!");
    }
}
