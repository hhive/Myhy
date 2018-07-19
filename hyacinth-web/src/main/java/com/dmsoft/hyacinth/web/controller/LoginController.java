/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.web.controller;


import com.dmsoft.hyacinth.server.dto.UserDto;
import com.dmsoft.hyacinth.server.entity.User;
import com.dmsoft.hyacinth.server.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private RestTemplate restTemplate;

    @RequestMapping(value = "/index")
    public String index() {
        return "login";

    }
    @ResponseBody
    @RequestMapping(value = "/login",method =RequestMethod.POST)
    public User login(@RequestParam(value="Username",required = false) String username, @RequestParam(value = "Password",required = false) String password,HttpServletRequest request){
        User user = userService.validateUser(username,password);
        if(user!= null){
            HttpSession session = request.getSession(true);
            session.setAttribute("user",username);
            return user;
        }
        else{
            return null;
        }
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

