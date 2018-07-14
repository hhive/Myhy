package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.dao.UserDao;
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


@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    UserDao userDao;
    String username;
    Session session;


    @RequestMapping(value = "/pwd")
    public String changepwd() {
       // session.setAttribute("user",username);

        return "views/changePassword";
    }
  //  @SessionAttributes("userName");
  @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
  public String Submit(@ModelAttribute User user,
                       @RequestParam(name = "oldPassword") String oldPassword,
                       @RequestParam(name = "newPassword") String newPassword,
                       String username,
                       HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
      HttpSession session = request.getSession();
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      username = (String) session.getAttribute("username");

      if (userService.validateUser(username, oldPassword) != null) {
          if (oldPassword.equals(newPassword) != true) {
              userService.changePassword(username, oldPassword, newPassword);
              out.print("<script language=\"javascript\">alert('修改密码成功！');window.location.href='/index1'</script>");
              return "index";
          } else {
              out.print("<script language=\"javascript\">alert('新密码与旧密码重复！');window.location.href='/user/pwd'</script>");
              return "views/changePassword";
          }
      } else {
          out.print("<script language=\"javascript\">alert('旧密码输入错误！');window.location.href='/login'</script>");
          return "login";
      }
  }}