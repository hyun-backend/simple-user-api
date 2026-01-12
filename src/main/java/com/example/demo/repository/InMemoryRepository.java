package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InMemoryRepository implements UserRepository {

    private final Map<Long, User> store = new HashMap<>();
    private long sequence = 1L;

    @Override
    public User save(User user) {
        store.put(user.getId(), user);
        return user;
    }

    @Override
    public User findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<User> findByName(String name) {
        return store.values().stream()
                .filter(user -> user.getName().equals(name))
                .toList();
    }
}
