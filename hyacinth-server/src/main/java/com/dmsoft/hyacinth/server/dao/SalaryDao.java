package com.dmsoft.hyacinth.server.dao;

import com.dmsoft.hyacinth.server.entity.Salary;
import com.dmsoft.hyacinth.server.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface SalaryDao extends PagingAndSortingRepository<Salary, Long>, JpaSpecificationExecutor<Salary> {

      Salary findByCode(String code);
    @Modifying
    @Transactional
    @Query(value = "delete from t_salary",nativeQuery=true)
    void deleteall();
//    @Modifying
//    @Transactional
//    @Query(value = "select * from t_salary",nativeQuery=true)
//    void findall();
    @Modifying
    @Transactional
    @Query(value = "insert into t_salary values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15,?16,?17,?18,?19,?20" +
            ",?21,?22,?23,?24,?25,?26,?27,?28,?29,?30,?31)",nativeQuery=true)
    void insert(Long va1,String va2,String va3,float va4,float va5,float va6,float va7,float va8,float va9,float va10
            ,float va11,float va12,float va13,float va14,float va15,float va16,float va17,float va18,float va19
            ,float va20,float va21,float va22,float va23,float va24,float va25,float va26,float va27,float va28
            ,float va29,float va30,float va31);

}
