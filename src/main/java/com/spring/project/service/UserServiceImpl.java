package com.spring.project.service;

import com.spring.project.dao.RoleDao;
import com.spring.project.dao.UserDao;
import com.spring.project.model.Role;
import com.spring.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public List<User> listUsers() {
        return this.userDao.findAll();
    }

    @Override
    public void updateUser(User user) {
        userDao.delete(user.getId());
        save(user);
    }

    @Override
    public void removeUser(long id) {
        userDao.delete(id);
    }

    @Override
    public User getUserById(long id) {
        return userDao.findOne(id);
    }
}
