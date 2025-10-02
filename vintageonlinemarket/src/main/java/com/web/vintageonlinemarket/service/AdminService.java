package com.web.vintageonlinemarket.service;



import com.web.vintageonlinemarket.entity.Admin;
import com.web.vintageonlinemarket.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;

    public List<Admin> getAll() {
        return repository.findAll();
    }

    public Admin getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Admin save(Admin admin) {
        return repository.save(admin);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Admin login(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }
}
