package com.likelen.example.login.components.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.apache.shiro.mgt.SecurityManager;

import javax.annotation.PostConstruct;

@Configuration
public class ShiroConfig {

    @Autowired
    private SecurityManager securityManager;

    @Bean
    public Realm simpleRealm(){
        return new HelloRealm();
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleRealm());
        return defaultSecurityManager;
    }

    @PostConstruct
    private void initStaticSecurityManager() {
        SecurityUtils.setSecurityManager(securityManager);
    }
}
