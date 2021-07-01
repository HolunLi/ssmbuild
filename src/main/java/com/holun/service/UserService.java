package com.holun.service;

import com.holun.entity.User;

import java.util.List;

public interface UserService {

    //根据用户名和密码查询用户
    User selectUserByNameAndPwd(User user);

    //根据用户名查找用户
    String queryUserByName(String name);

    //根据密码查找用户
    List<String> queryUserByPwd(String pwd);
}
