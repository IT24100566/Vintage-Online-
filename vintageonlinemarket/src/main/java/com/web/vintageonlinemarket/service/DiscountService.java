package com.web.vintageonlinemarket.service;



import com.web.vintageonlinemarket.entity.Discount;
import com.web.vintageonlinemarket.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {
    @Autowired
    private DiscountRepository repository;

    public List<Discount> getAll() {
        return repository.findAll();
    }

    public Discount getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Discount save(Discount discount) {
        return repository.save(discount);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
