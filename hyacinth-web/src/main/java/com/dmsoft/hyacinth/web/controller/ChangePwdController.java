package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.dao.UserDao;
import com.dmsoft.hyacinth.server.dto.UserDto;
import com.dmsoft.hyacinth.server.entity.User;
import com.dmsoft.hyacinth.server.service.UserService;
import com.dmsoft.hyacinth.server.utils.PasswordHelper;
import org.apache.shiro.SecurityUtils;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping(value = "/user")
public class ChangePwdController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordHelper passwordHelper;


    @RequestMapping(value = "/pwd")
    public String changepwd() {
        // session.setAttribute("user",username);
        return "views/changePassword";
    }

    @RequestMapping(value = "/cancel")
    public String Cancel() {
        return "index";
    }

    //  @SessionAttributes("userName");
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public void Submit(@ModelAttribute User user,
                         @RequestParam(name = "oldPassword") String oldPassword,
                         @RequestParam(name = "newPassword") String newPassword,
                         HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        user = (User) SecurityUtils.getSubject().getPrincipal();

       // System.out.println(user.getEmail() + "11111111");
        String pwd = passwordHelper.decryptPassword(user, oldPassword);
        System.out.println("加密后的oldpassword" + pwd);

        //数据库的密码与输入的旧密码匹配
        if (user.getPassword().equals(pwd)) {
            userService.changePassword(user.getLoginName(), newPassword);
            System.out.println("修改成功");

        }else{

        }
    }
}
//    public String Submit(@ModelAttribute User user, Model model, @RequestParam(name = "oldPassword") String oldPassword,
//                         @RequestParam(name = "newPassword") String newPassword, HttpServletResponse response) throws IOException {
//        //TODO
//
//        user = (User) SecurityUtils.getSubject().getPrincipal();
//        String pwd=passwordHelper.decryptPassword(user,oldPassword);
//        System.out.println("加密后的oldpassword"+pwd);
//        if ( user.getPassword().equals(pwd)) {
//            // passwordHelper.encryptPassword(user);
//            userService.changePassword(
//                    user.getLoginName(), newPassword);
//
//            return "success";
//        } else {
//            return "error";
//        }
//    }
//}