package com.example.demo.repository;

import com.example.demo.domain.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    User findById(Long id);

    List<User> findAll();

    List<User> findByName(String name);

}

// test commit

// test commit 2