package com.likelen.example.login.components.shiro;

import com.likelen.example.login.domain.UserService;
import com.likelen.example.login.domain.model.LoginRequest;
import com.likelen.example.login.domain.model.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloRealmTest {

    @Autowired
    UserService userService;

    @Test
    void name() {
        userService.register(new RegisterRequest("Len", "mike@naver.com", "12345"));

        LoginRequest request = new LoginRequest("mike@naver.com", "12345");
        userService.login(request);


    }
}
