package com.example.service;

import com.example.model.User;

import java.util.List;

public interface UserService {
    User findByMail(String mail);
    List<User> getAll();
}
