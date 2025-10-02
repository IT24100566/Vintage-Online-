package com.web.vintageonlinemarket.repository;



import com.web.vintageonlinemarket.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}