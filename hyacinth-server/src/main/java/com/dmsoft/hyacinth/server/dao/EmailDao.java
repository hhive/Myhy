package com.dmsoft.hyacinth.server.dao;

import com.dmsoft.hyacinth.server.entity.Email;
import com.dmsoft.hyacinth.server.entity.Log;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmailDao extends PagingAndSortingRepository<Email, Long>, JpaSpecificationExecutor<Log> {
    Email findById(Long id);
}
