package com.likelen.example.login.domain;

import com.likelen.example.login.domain.model.RegisterRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository repository;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User(1L, "Len", "joenggyu0@gmail.com", "12345");
    }

    @Test
    void registerTest() {
        given(repository.save(any(User.class))).willReturn(user);

        RegisterRequest len = new RegisterRequest("Len", "joenggyu0@gmail.com", "12345");
        User user = len.toUser();
        User registeredUser = userService.register(len);

        verify(repository).save(user);
        assertThat(registeredUser.getId()).isNotNull();
    }

    @Test
    void findUserTest() {
        given(repository.findUserById(1L)).willReturn(user);

        userService.findUser(1L);

        verify(repository).findUserById(1L);
    }
}
