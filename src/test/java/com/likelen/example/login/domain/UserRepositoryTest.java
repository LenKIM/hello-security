package com.likelen.example.login.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    void saveAndFind() {
        User user = new User(null, "Len", "joenggyu0@gmail.com", "1234");

        User save = repository.save(user);
        Long id = save.getId();
        assertThat(id).isNotNull();

        User find = repository.findUserById(id);
        assertThat(find).isEqualTo(save);
    }
}
