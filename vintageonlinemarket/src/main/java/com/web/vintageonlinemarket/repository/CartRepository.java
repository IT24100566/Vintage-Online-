package com.web.vintageonlinemarket.repository;

import com.web.vintageonlinemarket.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
