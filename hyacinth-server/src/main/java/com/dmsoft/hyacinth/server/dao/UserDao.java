/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.dao;

import com.dmsoft.hyacinth.server.dto.UserDto;
import com.dmsoft.hyacinth.server.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

    @Query("from User where loginName=:loginName")
    User findByLoginName(@Param("loginName") String loginName);
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
    @Query("update User user set user.password = ?2 where user.loginName = ?1")
    void updatePwd(String userName, String newPwd);

    @Modifying
    @Transactional
    @Query(value = "insert into t_user (code,loginName,name,password,email) values(?1,?2,?3,?4,?5)",nativeQuery = true)
    void insert(String code,String username,String name,String password,String email);

    @Modifying
    @Transactional
    @Query("update User user set user.code=?2,user.loginName=?3,user.name=?4,user.password = ?5,user.email=?6 where user.id = ?1")
    void update(long id,String code,String username,String name,String password,String email);


    @Modifying
    @Transactional
    @Query("delete from User where id=?1")
    void deleteOne(long id);

    @Query("from User where code = ?1")
    User findUserByCode(String code);

    //分页展示
    @Query(value=" select*from USER limit 1,25",nativeQuery = true)
     List<User> UserList(int startRecord, int pageSize);

    //用户表中数据记录数
    @Query(value = "select count(*) from t_user",nativeQuery = true)
    int gettstunumber( );

    User findByCode(String code);
}
