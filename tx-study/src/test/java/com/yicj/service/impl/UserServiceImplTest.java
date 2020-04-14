package com.yicj.service.impl;

import com.yicj.model.User;
import com.yicj.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    @Test
    public void save() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml") ;
        UserService userService = context.getBean(UserService.class);
        User user = new User()  ;
        user.setName("李四");
        user.setAge(20);
        user.setSex("男");
        userService.save(user);
    }
}