package com.example.productservice.service;

import com.example.productservice.model.User;
import com.example.productservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
}
