package com.elearning.nguyentheanh_shopping_tuan02.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order   {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private double basePrice;
    private String status;
    private String taxType;
    private String paymentMethod;
    private double finalAmount;
}