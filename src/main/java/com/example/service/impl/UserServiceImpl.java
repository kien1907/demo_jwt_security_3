package com.example.service.impl;

import com.example.model.User;
import com.example.reppsistory.UserRepo;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public User findByMail(String mail) {
        return userRepo.findByMail(mail);
    }

    @Override
    public List<User> getAll() {
        return userRepo.getAll();
    }
}
