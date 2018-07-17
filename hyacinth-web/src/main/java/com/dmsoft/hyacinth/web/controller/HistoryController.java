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
    public void packagehistory(){
        Date date=new Date();
        logService.insert(null,date,"user","打包图片");
    }
    public  void sendhistory(){
        Date date=new Date();
        logService.insert(null,date,"user","发送邮件");
    }
}
