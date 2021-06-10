package com.likelen.example.login.domain;

import com.likelen.example.login.domain.model.LoginRequest;
import com.likelen.example.login.domain.model.RegisterRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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

    public User login(LoginRequest request) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(request.getEmail(), request.getPassword());

        subject.login(usernamePasswordToken);
        String userMail = (String) subject.getPrincipal();

        return repository.findByEmail(userMail);
    }

    public void doLogOut(){
        SecurityUtils.getSubject().logout();
    }

    public User getUserEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    public User findUserByEmail(String email){
        return repository.findByEmail(email);
    }
}
