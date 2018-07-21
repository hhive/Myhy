package com.dmsoft.hyacinth.server.dao;

import com.dmsoft.hyacinth.server.entity.Email;
import com.dmsoft.hyacinth.server.entity.Log;
import com.dmsoft.hyacinth.server.entity.Staff;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EmailDao extends PagingAndSortingRepository<Email, Long>, JpaSpecificationExecutor<Log> {
    Email findById(Long id);

    @Modifying
    @Transactional
    @Query(value = "update t_email set email=?1,password=?2,emailtype=?3,post=?4 where id=1",nativeQuery=true)
    void update(String email,String password,String emailtype,String post);
}
