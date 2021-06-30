package com.holun.service;

import com.holun.entity.User;

public interface UserService {

    //根据用户名和密码查询用户
    User selectUserByNameAndPwd(User user);
}
