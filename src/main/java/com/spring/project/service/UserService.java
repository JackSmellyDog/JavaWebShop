package com.spring.project.service;

import com.spring.project.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
