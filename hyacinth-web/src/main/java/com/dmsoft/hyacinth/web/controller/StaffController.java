/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.dto.StaffDto;
import com.dmsoft.hyacinth.server.service.StaffService;
import com.dmsoft.hyacinth.server.service.UserService;
import com.google.common.collect.Lists;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;
    private UserService userService;

    @RequestMapping(value = "/list")
    public String all() {
        return "views/staff/staffsearch";
    }

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<StaffDto> findAll() {
        List<StaffDto> list = staffService.findAll();
        return list;
    }

//    @RequestMapping(value = "/search")
//    public String search(@RequestParam("searchmsg")String msg){
//        StaffDto staffDto;
//        staffDto=staffService.findByCode(msg);
//        if(staffDto==null){
//            staffDto=staffService.findByName(msg);
//            if(staffDto==null) return null;
//            else return  "index";
//        }else  return "login";
//    }

    @RequestMapping(value = "/setEmail")
    public String setEmail(HttpServletRequest request
                           ){
       // @RequestParam(name = "email") String email
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        System.out.println(username);
        String userEmail=userService.getUserEamil(username);
        System.out.println(userEmail);
        return "/index1";
    }
    @ResponseBody
    @RequestMapping(value ="/print",method = RequestMethod.POST)
    public StaffDto findcheckbox(@RequestParam(value = "id")String msg){
        System.out.println(Long.parseLong(msg));
        StaffDto staff = staffService.findById(Long.parseLong(msg));

        return staff;
    }

    @ResponseBody
    @RequestMapping(value = "/search",method = RequestMethod.POST)
//public StaffDto search(HttpServletRequest session){
    public List<StaffDto> search( HttpServletRequest request){
        HttpSession session = request.getSession(true);
        String msg = (String) session.getAttribute("message");
        List<StaffDto> staffDto= Lists.newArrayList();
        if(msg==null) {return staffDto=staffService.findAll();}
        else {
            staffDto=staffService.findByCode(msg);
            if (staffDto == null) {
                staffDto=staffService.findByName(msg);
                session.setAttribute("message",null);
                return staffDto;
            } else {
                session.setAttribute("message",null);
                return staffDto;
            }
        }
    }
}
