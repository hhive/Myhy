package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.dto.EmailDto;
import com.dmsoft.hyacinth.server.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Properties;

@Controller
@RequestMapping(value = "/views")
public class SendemailController {

//    @RequestMapping(value = "/sendEmail")
//    public String email(){
//        return "views/sendEmail";
//    }

    @RequestMapping(value = "/Email")
    public ModelAndView sendSalaryWithAttachment(String name,String to,EmailDto email) {


//        System.out.println(name);
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        String From=email.getEmail();
        mailSender.setHost(email.getEmailtype());
        mailSender.setUsername(email.getEmail());
        mailSender.setPassword(email.getPassword()); // 这里要用邀请码，不是你登录邮箱的密码

        Properties pro = System.getProperties(); // 下面各项缺一不可
        pro.put("mail.smtp.auth", "true");
        pro.put("mail.smtp.ssl.enable", "true");
        pro.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        pro.put("mail.smtp.port",email.getPost());//端口？
        mailSender.setJavaMailProperties(pro);
        File f=new File("d:/"+name+".zip");
        String title ="工资信息";//邮件标题
        String content ="Last month "+name+"'s salary imformation.\npassword is your code";//邮件描述
            MimeMessage msg = mailSender.createMimeMessage();
            try {

                MimeMessageHelper helper = new MimeMessageHelper(msg,true);
                helper.setFrom(From);
                helper.setTo(to);
                helper.setSubject(title);
                helper.setText(content,true);   //true表示邮件有附件
                FileSystemResource fileSystemResource = new FileSystemResource(f);
                helper.addAttachment(name+"的工资信息.zip",fileSystemResource);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mailSender.send(msg);
        ModelAndView mv = new ModelAndView();
        mv.addObject("modelandviewmsg", "发送成功！");
        mv.setViewName("views/sendEmail");
        return mv;
    }

}