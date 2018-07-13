package com.dmsoft.hyacinth.server.service;

import com.dmsoft.hyacinth.server.dto.SalaryDto;
import com.dmsoft.hyacinth.server.entity.Salary;

import java.util.List;

public interface SalaryService {
    SalaryDto findbycode(String code);
    void deleteall();
    void save(SalaryDto salaryDto);
    void insert(String va1,String va2,float va3,float va4,float va5,float va6,float va7,float va8,float va9,float va10
            ,float va11,float va12,float va13,float va14,float va15,float va16,float va17,float va18,float va19
            ,float va20,float va21,float va22,float va23,float va24,float va25,float va26,float va27,float va28
            ,float va29,float va30);
    List<SalaryDto> findAll();
}
