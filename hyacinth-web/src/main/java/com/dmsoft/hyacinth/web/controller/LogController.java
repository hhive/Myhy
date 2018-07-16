package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.dto.LogDto;
import com.dmsoft.hyacinth.server.service.impl.LogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/log")
public class LogController {
    @Autowired
    private LogServiceImpl logService;
    @RequestMapping(value = "/list")
    public String all() {
        return "views/log/logs";
    }

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<LogDto> findAll() {
        List<LogDto> list = logService.findAll();
        return list;
    }
}
