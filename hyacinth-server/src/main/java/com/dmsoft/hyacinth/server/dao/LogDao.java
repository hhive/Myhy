/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.dao;

import com.dmsoft.bamboo.common.persistence.BaseEntity;
import com.dmsoft.hyacinth.server.entity.Log;
import com.dmsoft.hyacinth.server.entity.Salary;
import com.dmsoft.hyacinth.server.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;



public interface LogDao  extends PagingAndSortingRepository<Log, Long>, JpaSpecificationExecutor<Log> {



    @Modifying
    @Transactional
    @Query(value = "insert into t_log values(?1,?2,?3,?4)",nativeQuery=true)
    void insert(Long id,Date opera_time,String opera_name,String description);
}
