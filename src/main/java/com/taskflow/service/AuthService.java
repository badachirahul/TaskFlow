package com.taskflow.service;

import com.taskflow.payload.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    public ResponseEntity<?> loginUser(LoginRequest loginRequest);
}
