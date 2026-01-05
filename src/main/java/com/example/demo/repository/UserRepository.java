package com.example.demo.repository;

import com.example.demo.domain.User;

import java.util.List;

public interface UserRepository {

    Long nextId();

    User save(User user);

    User findById(Long id);

    List<User> findAll();

}

// test commit

// test commit 2