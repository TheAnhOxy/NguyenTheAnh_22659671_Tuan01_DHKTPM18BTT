package com.elearning.nguyentheanh_shopping_tuan02.cores;

public abstract class PaymentDecorator implements PaymentStrategy {
    protected PaymentStrategy decoratedPayment;

    public PaymentDecorator(PaymentStrategy payment) {
        this.decoratedPayment = payment;
    }

    @Override
    public void pay(double amount) {
        decoratedPayment.pay(amount);
    }
}