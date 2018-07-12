package com.dmsoft.hyacinth.server.service.impl;

import com.dmsoft.hyacinth.server.dao.SalaryDao;
import com.dmsoft.hyacinth.server.dto.SalaryDto;
import com.dmsoft.hyacinth.server.entity.Salary;
import com.dmsoft.hyacinth.server.service.SalaryService;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class SalaryServiceImpl implements SalaryService {
    private SalaryDao salaryDao;

    @Override
    public SalaryDto findbycode(String code) {
        Salary entity = salaryDao.findByCode(code);
        SalaryDto dto = new SalaryDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public List<SalaryDto> findAll() {
        Iterable<Salary> entityList = salaryDao.
                findAll();

        List<SalaryDto> list = Lists.newArrayList();

        entityList.forEach(entity -> {
            SalaryDto dto = new SalaryDto();
            BeanUtils.copyProperties(entity, dto);
            list.add(dto);
        });

        return list;
    }

    @Override
    public void deleteall() {
        salaryDao.deleteAll();
    }

    @Override
    public void save(Salary salary) {
        salaryDao.save(salary);
    }
}
