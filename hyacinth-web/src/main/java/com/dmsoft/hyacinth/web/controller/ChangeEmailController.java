package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class ChangeEmailController {
    @Autowired
    private EmailService emailService;
    @RequestMapping(value = "/changeemail")
    public String change(@RequestParam(name = "newEmail")String email,@RequestParam(name = "Password")String password,
    @RequestParam(name = "type")String type,@RequestParam(name = "post")String post, HttpServletResponse response)throws IOException {
        PrintWriter out = response.getWriter();
        emailService.update(email,password,type,post);
        out.print("<script language=\"javascript\">alert('Update Email Success!');window.location.href='/success'</script>");
        return "index";
    }
}
