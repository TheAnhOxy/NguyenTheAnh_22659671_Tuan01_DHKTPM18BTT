package com.elearning.nguyentheanh_shopping_tuan02.controller;

import com.elearning.nguyentheanh_shopping_tuan02.repository.OrderRepository;
import com.elearning.nguyentheanh_shopping_tuan02.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public String listOrders(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "order-list";
    }

    @GetMapping("/create")
    public String showCreateForm() {
        return "order-create";
    }

    @PostMapping("/save")
    public String saveOrder(@RequestParam String productName,
                            @RequestParam double basePrice,
                            @RequestParam String taxType,
                            @RequestParam String paymentMethod) {
        orderService.createOrder(productName, basePrice, taxType, paymentMethod);
        return "redirect:/orders/list";
    }

    // BỔ SUNG: Xử lý chuyển trạng thái (Next State)
    @PostMapping("/advance")
    public String advanceOrder(@RequestParam Long orderId,
                               @RequestParam String paymentType) {
        orderService.processOrder(orderId, paymentType);
        return "redirect:/orders/list";
    }

    @PostMapping("/cancel")
    public String cancelOrder(@RequestParam Long orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/orders/list";
    }

    // BỔ SUNG: Xóa đơn hàng
    @PostMapping("/delete")
    public String deleteOrder(@RequestParam Long orderId) {
        orderRepository.deleteById(orderId);
        return "redirect:/orders/list";
    }
}