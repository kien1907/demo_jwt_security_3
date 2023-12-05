package com.example.service;

import com.example.dto.request.LoginRequest;

public interface AuthenticationService {
    String login(LoginRequest loginRequest);
}
