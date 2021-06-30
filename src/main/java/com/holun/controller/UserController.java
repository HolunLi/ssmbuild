package com.holun.controller;

import com.holun.entity.User;
import com.holun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    @Qualifier("userServiceImpl")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/toLoginPage")
    public String toLoginPage(HttpServletRequest request, HttpSession session) {
        session.setAttribute("uname", request.getParameter("username"));
        return "redirect:/book/allBooks";
    }

    @RequestMapping("/loginCheck")
    @ResponseBody
    public String loginCheck(User user) {
       if (userService.selectUserByNameAndPwd(user) == null) {
          return "false";
       }
       else
           return "true";
    }
}
