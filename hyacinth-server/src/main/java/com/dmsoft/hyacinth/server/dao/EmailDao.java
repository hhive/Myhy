package com.dmsoft.hyacinth.server.dao;

import com.dmsoft.hyacinth.server.entity.Email;
import com.dmsoft.hyacinth.server.entity.Log;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EmailDao extends PagingAndSortingRepository<Email, Long>, JpaSpecificationExecutor<Log> {
    Email findById(Long id);
    @Modifying
    @Transactional
    @Query(value = "update t_email set email=?1,password=?2 where id=1",nativeQuery=true)
    void update(String email,String password);
}
