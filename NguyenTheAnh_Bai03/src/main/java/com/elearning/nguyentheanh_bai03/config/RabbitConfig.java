package com.shop.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String QUEUE_NAME = "emailQueue";
    public static final String EXCHANGE_NAME = "emailExchange";
    public static final String ROUTING_KEY = "emailRoutingKey";

    // 1. Khai báo hàng đợi (Queue)
    @Bean
    public Queue emailQueue() {
        return new Queue(QUEUE_NAME, true); // true = durable, hàng đợi không mất khi restart RabbitMQ
    }

    // 2. Khai báo Exchange (Bộ điều hướng)
    @Bean
    public TopicExchange emailExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    // 3. Liên kết (Binding) Queue với Exchange thông qua Routing Key
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
}