package com.shop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t_order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String email;
    private String ticketType;
}