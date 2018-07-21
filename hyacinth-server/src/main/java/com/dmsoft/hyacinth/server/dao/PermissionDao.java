package com.dmsoft.hyacinth.server.dao;

import com.dmsoft.hyacinth.server.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PermissionDao extends PagingAndSortingRepository<User, Long>,JpaSpecificationExecutor<User> {

}
