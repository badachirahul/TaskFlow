package com.taskflow.serviceimpl;

import com.taskflow.entity.User;
import com.taskflow.payload.LoginRequest;
import com.taskflow.repository.UserRepository;
import com.taskflow.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {
        String enteredUserEmail = loginRequest.getUserEmail();
        String enteredUserPassword = loginRequest.getUserPassword();

        User user = userRepository.findByUserEmail(enteredUserEmail)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        if(user.getUserPassword().equals(enteredUserPassword)) {
            return ResponseEntity.ok("Login Successfull");
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
