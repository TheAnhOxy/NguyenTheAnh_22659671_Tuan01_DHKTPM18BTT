package com.shop.controller;

import com.shop.entity.Order;
import com.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/place")
    public String placeOrder(@ModelAttribute Order order, Model model) {
        orderService.placeOrder(order);
        model.addAttribute("msg", "Đặt vé thành công! Vui lòng kiểm tra email sau vài giây.");
        return "result"; // Trả về kết quả
    }
}