package com.example.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.auth.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}