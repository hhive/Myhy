/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.dto.StaffDto;
import com.dmsoft.hyacinth.server.service.StaffService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @RequestMapping(value = "/list")
    public String all() {
        return "views/staff/staffs";
    }

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<StaffDto> findAll() {
        List<StaffDto> list = staffService.findAll();
        return list;
    }

    @RequestMapping(value = "/search")
    public String search(@RequestParam("searchmsg")String msg){
        StaffDto staffDto;
        staffDto=staffService.findByCode(msg);
        if(staffDto==null){
            staffDto=staffService.findByName(msg);
            if(staffDto==null) return null;
            else return  "index";
        }else  return "login";
    }
}
