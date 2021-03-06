package com.example.auth.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.auth.entities.Role;
import com.example.auth.entities.User;
import com.example.auth.repositories.RoleRepository;
import com.example.auth.repositories.UserRepository;
import java.util.Collections;

@Service(value = "UserServiceV1")
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        Role role = roleRepository.findByName("ROLE_USER");
        user.setRole(Collections.singletonList(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User changePassword(Integer userId, String oldPassword, String newPassword) {
        User user = userRepository.findById(userId).get();
        if (user.getPassword().equals(passwordEncoder.encode(oldPassword)))
            user.setPassword(passwordEncoder.encode(newPassword));
        return userRepository.save(user);
    }

    public User restorePassword(String email, String newPassword) {
        User user = userRepository.findByEmail(email);
        user.setPassword(passwordEncoder.encode(newPassword));
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByLoginAndPassword(String email, String password) {
        User userEntity = findByEmail(email);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }
}