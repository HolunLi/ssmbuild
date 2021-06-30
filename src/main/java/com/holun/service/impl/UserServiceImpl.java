package com.holun.service.impl;

import com.holun.dao.UserMapper;
import com.holun.entity.User;
import com.holun.service.UserService;

public class UserServiceImpl implements UserService {

    private UserMapper userMapper ;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User selectUserByNameAndPwd(User user) {
        return userMapper.selectUserByNameAndPwd(user);
    }
}
