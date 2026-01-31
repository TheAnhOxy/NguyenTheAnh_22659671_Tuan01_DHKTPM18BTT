package com.elearning.nguyentheanh_shopping_tuan02.repository;


import com.elearning.nguyentheanh_shopping_tuan02.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long > {
}
