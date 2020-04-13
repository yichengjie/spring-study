package com.yicj.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtils {
    private final static SqlSessionFactory sqlSessionFactory ;

    static {
        String resource = "resource/mybatis-config.xml";
        Reader reader = null ;
        try {
            reader = Resources.getResourceAsReader(resource) ;
        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println(e.getMessage());
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader) ;
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory ;
    }
}
