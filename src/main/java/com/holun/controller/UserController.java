package com.holun.controller;

import com.holun.entity.User;
import com.holun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    @Qualifier("userServiceImpl")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/loginCheck")
    @ResponseBody
    public String loginCheck(User user, HttpSession session) {

        //判断用户名密码是否为空
        if (user.getName() == "" && user.getPwd() == "")
            return "A";
        else if (user.getName() == "")
            return "B";
        else if (user.getPwd() == "")
            return "C";

        //判断输入的用户名和密码是否正确
        if (userService.selectUserByNameAndPwd(user) != null ) {
            session.setAttribute("uname", user.getName());
            return "a";
        }
        else if (userService.queryUserByName(user.getName()) == null && userService.queryUserByPwd(user.getPwd()).size() == 0)
            return "b";
        else if (userService.queryUserByName(user.getName()) == null )
            return "c";
        else
            return "d";
    }

    //退出登录
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("uname");

        return "redirect:/login.jsp";
    }
}
