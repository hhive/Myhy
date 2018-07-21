/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.service;

import com.dmsoft.hyacinth.server.dto.UserDto;
import com.dmsoft.hyacinth.server.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Peter on 2016/7/11.
 */
public interface UserService {

    /**
     * Find user information by id.
     *
     * @param id id
     * @return UserDto
     */
    UserDto findUserById(Long id);

    UserDto findUserByCode(String code);

    UserDto findByCode(String code);

    User findUserByusername(String username);
    /**
     * Find all users.
     *
     * @return List UserDto
     */
    List<UserDto> findAll();

    /**
     * Validate if login information is legal.
     *
     * @param userName name of user
     * @param password password of user
     * @return if legal return corresponding userDto, else return null
     */
    User validateUser(String userName, String password);

    /**
     * Change password for user.
     *
     * @param userName name of user
     * @param newPwd   the new password
     */
    void changePassword(String userName, String newPwd);

    void insert(String code,String username,String name,String password,String email);

    void update(long id,String code,String username,String name,String password,String email);

    void deleteOne(long id);

     List<UserDto> userList(int startRecord,int pageSize);

    int gettusernumber( );

    List<UserDto> findAllandPage(int startRecord,int pageSize);

    String getUserEamil(String loginName);

    User findByloginName(String loginname);

}
