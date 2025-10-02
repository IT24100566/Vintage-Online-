package com.web.vintageonlinemarket.service;



import com.web.vintageonlinemarket.entity.OrderItem;
import com.web.vintageonlinemarket.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository repository;

    public List<OrderItem> getAll() {
        return repository.findAll();
    }

    public OrderItem getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public OrderItem save(OrderItem orderItem) {
        return repository.save(orderItem);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
