/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.entity.User;
import com.dmsoft.hyacinth.server.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

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
    @RequestMapping(value = "/login" )
    public String login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.validateUser(username,password);
        if(user!= null){
            return "index";
        }
        else{
            return "login";
        }
    }
    @RequestMapping(value ="/send" )
    public String sendMessage(Model model, @RequestParam(value = "username", required = false , defaultValue = "")String username){
        model.addAttribute("username",username);
        return "index";


    }}

