package com.elearning.nguyentheanh_shopping_tuan02.service.impl;

import com.elearning.nguyentheanh_shopping_tuan02.cores.PaymentStrategy;
import com.elearning.nguyentheanh_shopping_tuan02.cores.ProcessingFeeDecorator;
import com.elearning.nguyentheanh_shopping_tuan02.cores.TaxStrategy;
import com.elearning.nguyentheanh_shopping_tuan02.cores.parternCoreImpl.CreditCardStrategy;
import com.elearning.nguyentheanh_shopping_tuan02.cores.parternCoreImpl.LuxuryTaxStrategy;
import com.elearning.nguyentheanh_shopping_tuan02.cores.parternCoreImpl.PaypalStrategy;
import com.elearning.nguyentheanh_shopping_tuan02.cores.parternCoreImpl.VatTaxStrategy;
import com.elearning.nguyentheanh_shopping_tuan02.entity.Order;
import com.elearning.nguyentheanh_shopping_tuan02.modal.OrderContext.OrderContext;
import com.elearning.nguyentheanh_shopping_tuan02.modal.request.OrderRequestDTO;
import com.elearning.nguyentheanh_shopping_tuan02.repository.OrderRepository;
import com.elearning.nguyentheanh_shopping_tuan02.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void processOrder(Long orderId, String paymentType) {
        Order entity = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        OrderContext context = new OrderContext(entity.getStatus());
        PaymentStrategy payment;
        if ("PAYPAL".equalsIgnoreCase(paymentType)) {
            payment = new PaypalStrategy();
        } else {
            payment = new CreditCardStrategy();
        }
        payment = new ProcessingFeeDecorator(payment);
        payment.pay(entity.getFinalAmount());
        context.nextStep(); // Chuyển từ NEW -> PROCESSING hoặc PROCESSING -> SHIPPED
        entity.setStatus(context.getState().getStatusName());
        orderRepository.save(entity);
    }

    @Override
    public void createOrder(String name, double price, String taxType, String payment) {
        TaxStrategy taxStrategy = taxType.equals("VAT") ? new VatTaxStrategy() : new LuxuryTaxStrategy();
        double totalTax = taxStrategy.calculateTax(price);

        Order order = new Order();
        order.setProductName(name);
        order.setBasePrice(price);
        order.setTaxType(taxType);
        order.setPaymentMethod(payment);
        order.setFinalAmount(price + totalTax);
        order.setStatus("NEW");

        orderRepository.save(order);
    }
    @Override
    public void cancelOrder(Long orderId) {
        Order entity = orderRepository.findById(orderId).get();
        OrderContext context = new OrderContext(entity.getStatus());

        context.cancelOrder(); // Chuyển state sang CANCELLED

        entity.setStatus(context.getState().getStatusName());
        orderRepository.save(entity);
    }
}

