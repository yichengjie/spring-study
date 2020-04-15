package com.yicj.service;

import com.yicj.exception.UserException;
import com.yicj.model.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED,rollbackFor = UserException.class)
public interface UserService {

    void save(User user) throws Exception;
}
