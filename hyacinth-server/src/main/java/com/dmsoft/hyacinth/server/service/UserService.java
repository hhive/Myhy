/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.service;

import com.dmsoft.hyacinth.server.dto.UserDto;

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
    UserDto validateUser(String userName, String password);

    /**
     * Change password for user.
     *
     * @param userName name of user
     * @param oldPwd   the old password
     * @param newPwd   the new password
     */
    void changePassword(String userName, String oldPwd, String newPwd);
}
