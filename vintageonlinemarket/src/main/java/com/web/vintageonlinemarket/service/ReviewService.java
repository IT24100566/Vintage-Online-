package com.web.vintageonlinemarket.service;



import com.web.vintageonlinemarket.entity.Review;
import com.web.vintageonlinemarket.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

    public List<Review> getAll() {
        return repository.findAll();
    }

    public Review getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Review save(Review review) {
        return repository.save(review);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
