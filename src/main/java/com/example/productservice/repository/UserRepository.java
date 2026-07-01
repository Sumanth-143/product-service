package com.example.productservice.repository;

import com.example.productservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String username);
}
