package com.elearning.nguyentheanh_shopping_tuan02.controller;

import com.elearning.nguyentheanh_shopping_tuan02.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/")
    public String redirectToOrders() {
        return "redirect:/orders/list";
    }
}