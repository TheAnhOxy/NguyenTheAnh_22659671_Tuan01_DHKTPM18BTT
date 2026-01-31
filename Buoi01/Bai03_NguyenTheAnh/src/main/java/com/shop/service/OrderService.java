package com.shop.service;

import com.shop.entity.Order;
import com.shop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final RabbitTemplate rabbitTemplate;
    private final JavaMailSender mailSender;
    public long placeOrderSync(Order order) {
        long startTime = System.currentTimeMillis();
        orderRepository.save(order);
        sendEmailDirectly(order);

        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    public long placeOrderWithMQ(Order order) {
        long startTime = System.currentTimeMillis();
        orderRepository.save(order);
        rabbitTemplate.convertAndSend("emailExchange", "emailRoutingKey", order);

        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    private void sendEmailDirectly(Order order) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(order.getEmail());
        message.setText("Xác nhận đơn hàng...");
        mailSender.send(message);
    }
}