package com.example.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.auth.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}