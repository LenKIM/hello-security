package com.likelen.example.login.components.shiro;

import com.likelen.example.login.domain.User;
import com.likelen.example.login.domain.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class HelloRealm extends AuthorizingRealm implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    protected ApplicationContext context;

    protected UserService userService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        userService = context.getBean(UserService.class);
    }
    // 인증
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("HelloRealm.doGetAuthenticationInfo");

        SimpleAuthenticationInfo authInfo = null;
        if (token instanceof UsernamePasswordToken){
            UsernamePasswordToken us = (UsernamePasswordToken) token;
            String username = us.getUsername();
            char[] password = us.getPassword();

            User find = userService.getUserEmailAndPassword(username, String.valueOf(password));
            return new SimpleAuthenticationInfo(find.getEmail(), find.getPassword(), find.getName());
        } else {
            throw new IllegalArgumentException("Token 확인 필요");
        }
    }
    // 인가

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("HelloRealm.doGetAuthorizationInfo");
        return null;
    }
}
