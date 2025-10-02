package com.web.vintageonlinemarket.repository;

import com.web.vintageonlinemarket.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
