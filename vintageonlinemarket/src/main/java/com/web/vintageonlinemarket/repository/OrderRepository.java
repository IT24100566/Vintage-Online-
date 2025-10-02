package com.web.vintageonlinemarket.repository;

import com.web.vintageonlinemarket.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
