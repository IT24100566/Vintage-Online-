/*package com.web.vintageonlinemarket.service;



import com.web.vintageonlinemarket.entity.User;
import com.web.vintageonlinemarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User login(String email, String password, String type) {
        return repository.findByEmailAndPasswordAndType(email, password, type);
    }
}*/

/*package com.web.vintageonlinemarket.service;

import com.web.vintageonlinemarket.entity.User;
import com.web.vintageonlinemarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User login(String email, String password, String type) {
        // Implement authentication logic
        User user = repository.findByEmailAndPassword(email, password); // Add this method to UserRepository
        if (user != null && user.getType().equals(type)) {
            return user;
        }
        return null; // or throw exception
    }
}*/

/*package com.web.vintageonlinemarket.service;

import com.web.vintageonlinemarket.entity.User;
import com.web.vintageonlinemarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User login(String email, String password, String type) {
        User user = repository.findByEmailAndPassword(email, password);
        if (user == null || !user.getType().equals(type)) {
            throw new RuntimeException("Invalid credentials or role mismatch");
        }
        return user;
    }
}*/

package com.web.vintageonlinemarket.service;

import com.web.vintageonlinemarket.entity.User;
import com.web.vintageonlinemarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User login(String email, String password, String type) {
        User user = repository.findByEmailAndPassword(email, password);
        if (user == null || !user.getType().equals(type)) {
            throw new RuntimeException("Invalid credentials or role mismatch");
        }
        return user;
    }
}
