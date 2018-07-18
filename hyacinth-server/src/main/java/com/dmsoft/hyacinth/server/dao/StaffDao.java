/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.dao;

import com.dmsoft.hyacinth.server.dto.StaffDto;
import com.dmsoft.hyacinth.server.entity.Staff;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

/**
 * Created by Peter on 2016/7/11.
 */
public interface StaffDao extends PagingAndSortingRepository<Staff, Long>, JpaSpecificationExecutor<Staff> {

    Staff findById(Long id);


    Staff findByCode(String code);
    List<Staff> findByName(String name);
    @Override
    void deleteAll();

    @Modifying
    @Transactional
    @Query(value = "insert into t_staff values (?1,?2,?3,?4,?5,?6,?7,?8)",nativeQuery=true)
    void insert(long id,String code,String name,String position,String department,String phone,String email,String emdate);

}
