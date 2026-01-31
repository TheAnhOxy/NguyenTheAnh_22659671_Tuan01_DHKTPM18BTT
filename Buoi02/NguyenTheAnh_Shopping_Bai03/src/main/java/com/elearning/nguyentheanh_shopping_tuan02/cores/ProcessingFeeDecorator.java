package com.elearning.nguyentheanh_shopping_tuan02.cores;

public class ProcessingFeeDecorator extends PaymentDecorator {
    private final double FEE = 2.0; // Phí cố định 2$

    public ProcessingFeeDecorator(PaymentStrategy payment) {
        super(payment);
    }

    @Override
    public void pay(double amount) {
        double amountWithFee = amount + FEE;
        System.out.print("[Decorator] Đã cộng phí xử lý " + FEE + "$. ");
        super.pay(amountWithFee);
    }
}
