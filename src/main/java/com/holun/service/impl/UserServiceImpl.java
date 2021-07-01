package com.holun.service.impl;

import com.holun.dao.UserMapper;
import com.holun.entity.User;
import com.holun.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserMapper userMapper ;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User selectUserByNameAndPwd(User user) {
        return userMapper.selectUserByNameAndPwd(user);
    }

    @Override
    public String queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }

    @Override
    public List<String> queryUserByPwd(String pwd) {
        return userMapper.queryUserByPwd(pwd);
    }
}
