package com.yicj.mapper;

import com.yicj.model.User;
import com.yicj.utils.MyBatisUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserMapperTest {
    private static SqlSessionFactory sqlSessionFactory ;
    static {
        sqlSessionFactory = MyBatisUtils.getSqlSessionFactory() ;
    }

    @Test
    public void testAdd(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class) ;
            User user = new User("tom",5) ;
            userMapper.insertUser(user);
            sqlSession.commit(); //这里一定要提交，不然数进不到数据库中
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void getUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUser(1);
            System.out.println(ReflectionToStringBuilder.toString(user));
        }finally {
            sqlSession.close();
        }
    }
}