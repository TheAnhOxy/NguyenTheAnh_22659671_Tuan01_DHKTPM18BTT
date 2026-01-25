package com.shop.service;

import com.shop.entity.Order;
import com.shop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final RabbitTemplate rabbitTemplate;

    @Transactional
    public void placeOrder(Order order) {
        orderRepository.save(order);

        Map<String, String> emailJob = new HashMap<>();
        emailJob.put("email", order.getEmail());
        emailJob.put("content", "Chúc mừng " + order.getCustomerName() + "! Bạn đã đặt vé " + order.getTicketType() + " thành công.");

        rabbitTemplate.convertAndSend("emailExchange", "emailRoutingKey", emailJob);
    }
}