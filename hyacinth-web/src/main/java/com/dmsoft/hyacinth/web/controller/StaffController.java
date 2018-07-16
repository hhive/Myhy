/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.dto.StaffDto;
import com.dmsoft.hyacinth.server.service.StaffService;
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
    @RequestMapping(value = "/search1",method = RequestMethod.GET)
    public String search1(@RequestParam(value = "message",required = false)String msg,HttpServletRequest request){
        HttpSession session = request.getSession(true);
        System.out.print(msg);
        if(msg=="") session.setAttribute("message",null);
        else session.setAttribute("message", msg);
        return "views/staff/staffsearch";
    }

    @ResponseBody
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    //public StaffDto search(HttpServletRequest session){
    public List<StaffDto> search( HttpServletRequest request){
        HttpSession session = request.getSession(true);

        String msg = (String) session.getAttribute("message");
        System.out.print("b");
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
