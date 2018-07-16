package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.dao.UserDao;
import com.dmsoft.hyacinth.server.dto.UserDto;
import com.dmsoft.hyacinth.server.service.UserService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String userView(){
        return "views/user/users";
    }

    @ResponseBody
    @RequestMapping(value = "/all")
    public Map getUserList(HttpServletRequest request){

        int page=Integer.parseInt(request.getParameter("page"));
        int pageSzie=Integer.parseInt(request.getParameter("rows"));//pageSzie
        int startRecord=(page-1)*pageSzie+1;

        int total=userService.gettusernumber();

        List<UserDto>  userinforlist=userService.userList(startRecord,pageSzie);
       // System.out.println("5555555555555555555");
        Map resultMap=new HashMap();
        resultMap.put("total",total-1);
        resultMap.put("rows",userinforlist);
        return resultMap;
    }

    @ResponseBody//如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public Map<String,String> insertUser(@RequestParam(name="code") String code,
                             @RequestParam(name="loginName") String loginName,
                             @RequestParam(name="name") String name,
                             @RequestParam(name="salt") String salt,
                             @RequestParam(name="password") String password,
                             @RequestParam(name="email") String email) {
        Map<String,String> map=new HashMap<>();
        userService.insert(code,loginName,name,salt,password,email);
        map.put("success","true");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/updateUser" ,method = RequestMethod.POST)
    public Map<String,String> updateUser(@RequestParam(name="id") long id,
                              @RequestParam(name="code" ) String code,
                              @RequestParam(name="loginName") String loginName,
                              @RequestParam(name="name") String name,
                              @RequestParam(name="salt") String salt,
                              @RequestParam(name="password") String password,
                              @RequestParam(name="email") String email){
        Map<String,String> map=new HashMap<>();
        userService.update(id,code,loginName,name,salt,password,email);
        map.put("success","true");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteOne")
    public Map<String,String> deleteOne(@RequestParam(name="id",required = false ) long id){
        Map<String,String> map=new HashMap<>();
        userService.deleteOne(id);
        map.put("success","true");
        return map;
    }

    @RequestMapping(value = "/code")
    public String findByCode(@RequestParam(name="id") String code){
        userService.findByCode(code);
        return "views/user/users";
    }

    @RequestMapping(value="username")
    public String findUserByusername( @RequestParam(name="id") String userName){
        userService.findUserByusername(userName);
        return "views/user/users";
    }
}