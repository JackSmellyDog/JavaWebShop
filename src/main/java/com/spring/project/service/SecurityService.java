package com.spring.project.service;

public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
