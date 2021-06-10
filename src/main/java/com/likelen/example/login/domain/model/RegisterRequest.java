package com.likelen.example.login.domain.model;

import com.likelen.example.login.domain.User;

public class RegisterRequest {

    private final String name;
    private final String email;
    private final String password;

    public RegisterRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User toUser() {
        return new User(null, name, email, password);
    }
}
