package com.spring.project.service;

import com.spring.project.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
    List<User> listUsers();

    void updateUser(User user);
    void removeUser(long id);
    User getUserById(long id);
}
