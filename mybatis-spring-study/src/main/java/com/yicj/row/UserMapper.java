package com.yicj.row;

import com.yicj.model.User;

import java.util.List;

public interface UserMapper {
    void insertUser(User user) ;
    User getUser(Integer id) ;
    List<User> selectAll() ;
}
