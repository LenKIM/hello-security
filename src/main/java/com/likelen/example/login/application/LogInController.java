package com.likelen.example.login.application;

import com.likelen.example.login.domain.User;
import com.likelen.example.login.domain.UserService;
import com.likelen.example.login.domain.model.RegisterRequest;
import com.likelen.example.login.domain.model.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class LogInController {

    @Autowired
    UserService service;

    @PostMapping(value = "/register")
    ResponseEntity<RegisterResponse> register(
            @RequestBody RegisterRequest userRequest) {
        User register = service.register(userRequest);
        return ResponseEntity.created(URI.create("/register/" + register.getId())).body(RegisterResponse.of(register));
    }

    @GetMapping(value = "/users/{userId}")
    ResponseEntity<RegisterResponse> getUser(@PathVariable Long userId) {
        User register = service.findUser(userId);
        return ResponseEntity.ok(RegisterResponse.of(register));
    }
}
