package com.likelen.example.login.domain.model;

import com.likelen.example.login.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RegisterResponse {

    private Long id;
    private String name;
    private String email;

    public static RegisterResponse of(User register) {
        return new RegisterResponse(register.getId(), register.getName(), register.getEmail());
    }
}
