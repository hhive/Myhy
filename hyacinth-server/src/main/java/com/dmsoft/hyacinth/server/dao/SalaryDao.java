package com.dmsoft.hyacinth.server.dao;

import com.dmsoft.hyacinth.server.entity.Salary;
import com.dmsoft.hyacinth.server.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SalaryDao extends PagingAndSortingRepository<Salary, Long>, JpaSpecificationExecutor<Salary> {

      Salary findByCode(String code);

    @Override
    void deleteAll();
}
