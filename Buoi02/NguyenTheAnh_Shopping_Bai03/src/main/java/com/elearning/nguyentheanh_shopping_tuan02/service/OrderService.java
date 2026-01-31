package com.elearning.nguyentheanh_shopping_tuan02.service;

import com.elearning.nguyentheanh_shopping_tuan02.entity.Order;
import com.elearning.nguyentheanh_shopping_tuan02.modal.request.OrderRequestDTO;

public interface OrderService {

    void processOrder(Long orderId, String paymentType);
    void cancelOrder(Long orderId);
    void createOrder(String name, double price, String taxType, String payment);

}
