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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


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
    public UserDto findUserById(Long id) {
        User entity = userDao.findById(id);
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(entity, dto);

        return dto;
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
          userDao.updatePwd(userName,newPwd,oldPwd);
   }

    @Override
    public void insert(String code,String username,String name,String salt,String password,String email){
        userDao.insert(code,username, name,salt,password, email);
    }

    @Override
    public   void update(long id,String code,String username,String name,String salt,String password,String email){
        userDao.update(id,code,username, name,salt,password, email);
    }

    @Override
    public void deleteOne(long id){
        userDao.deleteOne(id);
    }

    public UserDto findUserByCode (String code){
        User entity = userDao.findUserByCode(code);
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(entity,dto);

        return dto;
    }

    public UserDto findByCode (String code){
        User entity = userDao.findUserByCode(code);
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(entity,dto);

        return dto;
    }

    public UserDto findUserByusername(String username){
        User entity = userDao.findUserByCode(username);
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(entity,dto);

        return dto;
    }

    public List<UserDto> userList(int startRecord,int pageSize){

        //return userDao.UserList(startRecord,pageSize);
        Iterable<User> entityList = userDao.findAll();

        List<UserDto> list = Lists.newArrayList();

        entityList.forEach(entity -> {
            UserDto dto = new UserDto();
            BeanUtils.copyProperties(entity, dto);
            list.add(dto);
        });

        return list;
    }

    public int gettusernumber( ){
        System.out.println(userDao.gettstunumber());
        return userDao.gettstunumber();
    }

    public List<UserDto> findAllandPage (int startRecord,int pageSize){

        Pageable pageable = new PageRequest(0, pageSize, Sort.Direction.ASC, "id");
        Page<User> userPage = userDao.findAll(pageable);
        System.out.println(userPage);
       // List<UserDto> userList = userPage.getContent();
        List<UserDto> list = Lists.newArrayList();

        userPage.forEach(entity -> {
            UserDto dto = new UserDto();
            BeanUtils.copyProperties(entity, dto);
            list.add(dto);
        });
        System.out.println(list);
        return list;

    }

    public String getUserEamil(String loginName){
        String userEmail=userDao.findByLoginName(loginName).getEmail();
        return  userEmail;
    }



}
