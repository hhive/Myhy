/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.dao;

import com.dmsoft.hyacinth.server.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Peter on 2016/7/11.
 */

public interface UserDao extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {

    /**
     * Find user by id.
     *
     * @param id id.
     * @return User.
     */
    User findById(Long id);

    /**
     * Find user by login name.
     *
     * @param loginName login name.
     * @return User.
     */
    User findByLoginName(String loginName);

    /**
     * find user by loginName and password
     *
     * @param loginName loginName
     * @param password  password
     * @return a user
     */
    @Query(" from User where loginName = ?1 and password =?2")
    User findByLoginNameAndPassword(String loginName, String password);

    @Modifying
    @Transactional
    @Query("update User user set user.password = ?2 where user.loginName = ?1 and password = ?3")
    void update(String userName, String newPwd,String oldPwd);
}
