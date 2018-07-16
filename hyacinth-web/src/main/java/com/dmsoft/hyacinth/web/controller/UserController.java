package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.dto.StaffDto;
import com.dmsoft.hyacinth.server.service.StaffService;
import com.dmsoft.hyacinth.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import com.dmsoft.hyacinth.server.dto.StaffDto;
import com.dmsoft.hyacinth.server.entity.User;
import com.dmsoft.hyacinth.server.service.StaffService;
import com.dmsoft.hyacinth.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    String username;
    HttpSession session = getRequest().getSession();


    @RequestMapping(value = "/pwd")
    public String changepwd() {
        return "views/changePassword";
    }

    @RequestMapping(value = "/passwordCancel")
    public void changePassword(HttpServletRequest request) {
        session.getAttribute("username");
        String oldpwd = request.getParameter("oldpwd");//旧密码
        String newpwd = request.getParameter("newpwd");//新密码
        String confirm = request.getParameter("confirm");//确认新密码
        // userService.changePassword(username);
        userService.changePassword(username, oldpwd, newpwd);

    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return attrs.getRequest();
    }

}
/*public class StaffController {

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
}*/
