package com.likelen.example.login.domain;

import com.likelen.example.login.domain.model.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User register(RegisterRequest request) {

        return repository.save(request.toUser());
    }

    public User findUser(Long userId) {
        return repository.findUserById(userId);
    }
}
