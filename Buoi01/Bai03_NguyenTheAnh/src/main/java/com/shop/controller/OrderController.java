package com.shop.controller;

import com.shop.entity.Order;
import com.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/place")
    public String placeOrder(@ModelAttribute Order order, @RequestParam String mode, Model model) {
        long timeTaken;
        if ("mq".equals(mode)) {
            timeTaken = orderService.placeOrderWithMQ(order);
            System.out.println(">>> [DÙNG MQ] API phản hồi sau: " + timeTaken + " ms");
        } else {
            timeTaken = orderService.placeOrderSync(order);
            System.out.println(">>> [KHÔNG MQ] API phản hồi sau: " + timeTaken + " ms");
        }

        model.addAttribute("time", timeTaken);
        model.addAttribute("mode", mode);
        return "result";
    }
}