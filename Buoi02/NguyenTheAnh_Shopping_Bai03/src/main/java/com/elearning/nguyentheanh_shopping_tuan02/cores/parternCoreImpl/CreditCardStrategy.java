package com.elearning.nguyentheanh_shopping_tuan02.cores.parternCoreImpl;

import com.elearning.nguyentheanh_shopping_tuan02.cores.PaymentStrategy;

public class CreditCardStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + amount + " bằng thẻ Credit Card thành công.");
    }
}