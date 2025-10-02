package com.web.vintageonlinemarket.repository;

import com.web.vintageonlinemarket.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
