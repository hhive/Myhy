package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.service.UserService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.dmsoft.hyacinth.server.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.swing.*;


@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    String username;
    Session session;


    @RequestMapping(value = "/pwd")
    public String changepwd() {
       // session.setAttribute("user",username);

        return "views/changePassword";
    }
  //  @SessionAttributes("userName");
    @RequestMapping(value = "/changePassword" , method = RequestMethod.POST)
    public String Submit(@ModelAttribute User user, @RequestParam(name = "oldPassword")
            String oldPassword, @RequestParam(name = "newPassword") String newPassword ) {
        // TODO
        user.setName("user");
        user.setPassword("123456");
        if (user.getName() != null && user.getPassword() != null) {
            userService.changePassword(user.getName(), oldPassword, newPassword);
            return "views/success";
        } else {
            return "login";
        }
    }

   /* public String changePassword(HttpServletRequest request) {
       // session.getAttribute("username");
        username = "user";
        String oldpwd = request.getParameter("oldpwd");//旧密码
        String newpwd = request.getParameter("newpwd");//新密码
        String confirm = request.getParameter("confirm");//确认新密码
        // userService.changePassword(username);
        userService.changePassword(username, oldpwd, newpwd);
    return "index";
    }

    /*public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return attrs.getRequest();
    }*/

}