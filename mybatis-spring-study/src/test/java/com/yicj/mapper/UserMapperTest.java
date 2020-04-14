package com.yicj.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yicj.model.User;
import com.yicj.utils.RequestContextHolder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class UserMapperTest {
    private GenericXmlApplicationContext context ;
    private UserMapper userMapper ;


    @Before
    public void before(){
        RequestContextHolder.getInstance().setAirlineCode("XX");
        context = new GenericXmlApplicationContext("applicationContext.xml");
        userMapper = context.getBean("userMapper", UserMapper.class);
    }

    @Test
    public void getUser(){
        User user = userMapper.getUser(1);
        System.out.println(ReflectionToStringBuilder.toString(user));
    }

    @Test
    public void selectAllUser(){
        PageHelper.startPage(1,3);
        List<User> users = userMapper.selectAll();
        PageInfo pageInfo = new PageInfo(users) ;
        System.out.println(pageInfo);
    }
}