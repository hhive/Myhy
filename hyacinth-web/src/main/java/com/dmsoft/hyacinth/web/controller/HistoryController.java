package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.dao.LogDao;
import com.dmsoft.hyacinth.server.dto.LogDto;
import com.dmsoft.hyacinth.server.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.util.Date;

@Controller
public class HistoryController {
    @Autowired
    private LogService logService;

    @RequestMapping(value = "test")
    public void packagehistory(String code,HttpServletRequest request){
        HttpSession session=request.getSession(true);
        String username=(String) session.getAttribute("username");
        Date date=new Date();
        logService.insert(null,date,username,"打包"+code+"的图片");
    }
    public  void sendhistory(String code,HttpServletRequest request){
        HttpSession session=request.getSession(true);
        String username=(String) session.getAttribute("username");
        Date date=new Date();
        logService.insert(null,date,username,"发送"+code+"的邮件");
    }
}
