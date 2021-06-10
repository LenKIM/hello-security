package com.likelen.example.login.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    boolean existsUserByEmail(String email);

}
