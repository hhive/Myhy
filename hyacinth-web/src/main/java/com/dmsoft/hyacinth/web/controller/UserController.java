package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.dao.UserDao;
import com.dmsoft.hyacinth.server.dto.UserDto;
import com.dmsoft.hyacinth.server.service.UserService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.dmsoft.hyacinth.server.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.awt.print.Pageable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    UserDao userDao;

    @RequestMapping(value = "/userView")
    public String userView( ){
        return "views/user";
    }

    @ResponseBody
    @RequestMapping(value = "/all")
    public List<UserDto> findAll() {
        List<UserDto> list = userService.findAll();
        return list;
    }



    @ResponseBody//如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public void insertUser(@RequestParam(name="code") String code,
                           @RequestParam(name="loginName") String loginName,
                           @RequestParam(name="name") String name,
                           @RequestParam(name="salt") String salt,
                           @RequestParam(name="password") String password,
                           @RequestParam(name="email") String email) {
        userService.insert(code,loginName,name,salt,password,email);
    }

    @ResponseBody
    @RequestMapping(value = "/updateUser" ,method = RequestMethod.GET)
    public Map<String,String> updateUser(@RequestParam(name="id") long id,
                                         @RequestParam(name="code" ) String code,
                                         @RequestParam(name="loginName") String loginName,
                                         @RequestParam(name="name") String name,
                                         @RequestParam(name="salt") String salt,
                                         @RequestParam(name="password") String password,
                                         @RequestParam(name="email") String email){
        System.out.println("1111111111111112");
        Map<String,String> map=new HashMap<>();
        userService.update(id,code,loginName,name,salt,password,email);
        map.put("success","true");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteOne")
    public Map<String,String> deleteOne(@RequestParam(name="id") long id){
        Map<String,String> map=new HashMap<>();
        userService.deleteOne(id);
        map.put("success","true");
        return map;
    }

    @RequestMapping(value = "/code")
    public String findByCode(@RequestParam(name="id") String code){
        userService.findByCode(code);
        return "views/user/user";
    }

    @RequestMapping(value="/username")
    public String findUserByusername( @RequestParam(name="id") String userName){
        userService.findUserByusername(userName);
        return "views/user/user";
    }

    @ResponseBody
    @RequestMapping(value ="/print",method = RequestMethod.POST)
    public UserDto findcheckbox(@RequestParam(value = "id")String msg){
        System.out.println(Long.parseLong(msg));
        UserDto user = userService.findUserById(Long.parseLong(msg));

        return user;
    }

    @RequestMapping(value = "error")
    public String error(){
        return "views/error";
    }
}