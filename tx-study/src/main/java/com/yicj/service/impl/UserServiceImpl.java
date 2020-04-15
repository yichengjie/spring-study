package com.yicj.service.impl;

import com.yicj.model.User;
import com.yicj.service.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Types;

public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate ;

    //设置数据源
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource) ;
    }

    //@Transactional(rollbackFor = Exception.class)
    @Transactional
    @Override
    public void save(User user) throws Exception {
        String sql = "insert into user2 (name,age,sex) values (?,?,?)" ;
        Object[] params = {user.getName(), user.getAge(),user.getSex()};
        int [] types = {Types.VARCHAR,Types.INTEGER,Types.VARCHAR} ;
        jdbcTemplate.update(sql, params, types) ;
        //事务测试，加上这句话
        throw new RuntimeException("aa") ;
    }
}
