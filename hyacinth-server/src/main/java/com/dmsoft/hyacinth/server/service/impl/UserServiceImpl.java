 /*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.service.impl;

import com.dmsoft.hyacinth.server.dao.UserDao;
import com.dmsoft.hyacinth.server.dto.UserDto;
import com.dmsoft.hyacinth.server.entity.User;
import com.dmsoft.hyacinth.server.service.UserService;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.swing.JOptionPane;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDto findUserById(Long id) {
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        Iterable<User> entityList = userDao.findAll();
        List<UserDto> list = Lists.newArrayList();

        entityList.forEach(entity -> {
            UserDto dto = new UserDto();
            BeanUtils.copyProperties(entity, dto);
            list.add(dto);
        });
        return list;
    }

    @Override
    public User validateUser(String userName, String password) {
        User user = userDao.findByLoginNameAndPassword(userName, password);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public void changePassword(String userName, String oldPwd, String newPwd) {

          userDao.update(userName,newPwd,oldPwd);
//        User entity = userDao.findByLoginName(userName);
//        if (entity != null) {
//            if (entity.getPassword() == oldPwd) {
//                userDao.update( userName,oldPwd,newPwd);
//                JOptionPane.showMessageDialog(null, "可以", "alert", JOptionPane.ERROR_MESSAGE);
//            } else {
//                JOptionPane.showMessageDialog(null, "原密码错误，请重新输入", "alert", JOptionPane.ERROR_MESSAGE);
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "不对", "alert", JOptionPane.ERROR_MESSAGE);
//        }
   }
}
/* public StaffDto findByCode(String code) {
        Staff entity = staffDao.findByCode(code);

        StaffDto dto = new StaffDto();
        BeanUtils.copyProperties(entity, dto);

        return dto;
    }*/