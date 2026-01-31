package com.elearning.nguyentheanh_shopping_tuan02.modal.request;

import lombok.Data;

@Data
public class OrderRequestDTO {

    private String productName;
    private double basePrice;
    private String taxType; // VAT, LUXURY
    private String paymentMethod; // CREDIT_CARD, PAYPAL
    private boolean applyDiscount;

}
