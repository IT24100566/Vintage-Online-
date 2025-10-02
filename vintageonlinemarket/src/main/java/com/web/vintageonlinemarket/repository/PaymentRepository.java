package com.web.vintageonlinemarket.repository;

import com.web.vintageonlinemarket.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
