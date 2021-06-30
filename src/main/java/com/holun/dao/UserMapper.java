package com.holun.dao;

import com.holun.entity.User;

public interface UserMapper {

    //根据用户名和密码查询用户
    User selectUserByNameAndPwd(User user);
}
