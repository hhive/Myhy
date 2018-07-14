/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.web.controller;


import com.dmsoft.hyacinth.server.entity.User;
import com.dmsoft.hyacinth.server.service.UserService;

import org.apache.catalina.Session;
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
    @RequestMapping(value = "/login" )
    public String login(HttpServletRequest request){
        Map<String , String > map= new HashMap<>();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.validateUser(username,password);
        if(user!= null){

           return"index";
        }
        else{
            map.put("errorMsg","密码错误");
            return "login";
        }
    }
    @RequestMapping(value ="/send",method= RequestMethod.GET)
    //@ResponseBody
    public Map<String , String > ajax (@RequestParam("username") String loginname){
        System.out.println(loginname);
        Map<String , String > map= new HashMap<String, String>();
        map.put("name",loginname);
        return  map;
    }
    @RequestMapping(value = "/logout")
    public String logout() {
        return "logout";

    }
    }

