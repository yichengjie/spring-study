package com.yicj.row;

import com.yicj.model.User;

public interface UserMapper {

    void insertUser(User user) ;
    User getUser(Integer id) ;

}
