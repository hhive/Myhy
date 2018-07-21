/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.web.controller;


import com.dmsoft.hyacinth.server.dto.UserDto;
import com.dmsoft.hyacinth.server.entity.User;
import com.dmsoft.hyacinth.server.service.UserService;

import com.dmsoft.hyacinth.server.utils.PasswordHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordHelper passwordHelper;

//    @Autowired
//    private RestTemplate restTemplate;

    @RequestMapping(value = "/index")
    public String index() {
        return "login";

    }
    @ResponseBody
    @RequestMapping(value = "/login",method =RequestMethod.POST)
    public User login_check(@RequestParam(name="Username") String username, @RequestParam(name="Password") String password, Model model){
        System.out.println("*********************");
        Subject currentUser = SecurityUtils.getSubject();
        //登录
        try {
            User user = userService.findUserByusername(username);
            String pwd=passwordHelper.decryptPassword(user,password);
            UsernamePasswordToken token=new UsernamePasswordToken(username,pwd);
            currentUser.login(token);
            System.out.println("login in-------------");
            return user;
        } catch (Exception i) {
            return null;
        }
        //从session取出用户信息
//        User user = (User) currentUser.getPrincipal();
//        model.addAttribute("user", user);

    }

    @RequestMapping(value = "/success")
    public String success() {
        return "index";

    }
    @RequestMapping(value ="/logout")
    public String logout(){
        return "logout";
    }

    @RequestMapping(value="/home")
    public String home(){
        return "index";
    }
    //@RequestMapping(value ="/send",method= RequestMethod.GET)
    //public String sendMessage(Model model,@RequestParam(value ="username" , required = false,defaultValue = "") String username ){

    //    model.addAttribute("Loginname",username);
    //    return "index.html";
    //}

}