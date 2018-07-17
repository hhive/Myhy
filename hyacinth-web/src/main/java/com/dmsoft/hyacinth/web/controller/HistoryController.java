package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.dao.LogDao;
import com.dmsoft.hyacinth.server.dto.LogDto;
import com.dmsoft.hyacinth.server.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.crypto.Data;
import java.util.Date;

@Controller
public class HistoryController {
    @Autowired
    private LogService logService;

    @RequestMapping(value = "test")
    public String packagehistory(){
        Date date=new Date();
        logService.insert(null,date,null,"打包加密");
    return "views/success";
    }
    public  void sendhistory(){
        Date date=new Date();
        logService.insert(null,date,null,"发送邮件");
    }
}
