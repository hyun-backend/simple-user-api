package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(String name) {
        return userRepository.save(new User(0L, name));
    }

    public User find(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User changeName(Long id, String newName) {
        User user = userRepository.findById(id);
        if (user==null) return null;

        user.changeName(newName);
        return user;
    }
}
