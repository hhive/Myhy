package com.dmsoft.hyacinth.server.service;

import com.dmsoft.hyacinth.server.dto.SalaryDto;
import com.dmsoft.hyacinth.server.entity.Salary;

import java.util.List;

public interface SalaryService {
    SalaryDto findbycode(String code);
    void deleteall();
    void save(Salary salary);
    List<SalaryDto> findAll();
}
