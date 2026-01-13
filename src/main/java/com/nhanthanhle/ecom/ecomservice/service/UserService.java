package com.nhanthanhle.ecom.ecomservice.service;

import com.nhanthanhle.ecom.ecomservice.entity.User;
import com.nhanthanhle.ecom.ecomservice.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User getUser(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }
    public List<User> getListUsers() {
        return userRepository.findAll();
    }
    // trả void thì không tốt cho rest
    public User createUser(String name, String email, String password) {
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already exists");
        }

        // create user
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        // save, persit database

        return userRepository.save(newUser);
    }
}
