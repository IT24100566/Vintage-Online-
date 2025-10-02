package com.web.vintageonlinemarket.repository;

import com.web.vintageonlinemarket.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
