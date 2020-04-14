package com.yicj.mapper;

import com.yicj.model.User;
import com.yicj.utils.RequestContextHolder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserMapperTest {

    @Test
    public void getUser(){
        RequestContextHolder.getInstance().setAirlineCode("XX");
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        User user = userMapper.getUser(1);
        System.out.println(ReflectionToStringBuilder.toString(user));
    }
}