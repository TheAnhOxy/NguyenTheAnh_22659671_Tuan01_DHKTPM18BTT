package com.elearning.nguyentheanh_shopping_tuan02.cores.parternCoreImpl;

import com.elearning.nguyentheanh_shopping_tuan02.cores.PaymentDecorator;
import com.elearning.nguyentheanh_shopping_tuan02.cores.PaymentStrategy;

public class DiscountDecorator extends PaymentDecorator {
    public DiscountDecorator(PaymentStrategy payment) { super(payment); }
    @Override public void pay(double amount) {
        System.out.println("Applying 10% Discount...");
        decoratedPayment.pay(amount * 0.9);
    }
}