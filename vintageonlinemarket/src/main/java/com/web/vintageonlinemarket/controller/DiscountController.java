package com.web.vintageonlinemarket.controller;



import com.web.vintageonlinemarket.entity.Discount;
import com.web.vintageonlinemarket.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discounts")
public class DiscountController {
    @Autowired
    private DiscountService service;

    @GetMapping
    public List<Discount> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Discount getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Discount create(@RequestBody Discount discount) {
        return service.save(discount);
    }

    @PutMapping("/{id}")
    public Discount update(@PathVariable Long id, @RequestBody Discount discount) {
        discount.setDiscountId(id);
        return service.save(discount);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
