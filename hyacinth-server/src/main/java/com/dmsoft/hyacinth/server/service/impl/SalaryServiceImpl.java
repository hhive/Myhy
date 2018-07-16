package com.dmsoft.hyacinth.server.service.impl;

import com.dmsoft.hyacinth.server.dao.SalaryDao;
import com.dmsoft.hyacinth.server.dto.SalaryDto;
import com.dmsoft.hyacinth.server.entity.Salary;
import com.dmsoft.hyacinth.server.service.SalaryService;
import com.google.common.collect.Lists;
import com.sun.tools.corba.se.idl.constExpr.ShiftRight;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
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
        salaryDao.deleteall();
    }

    @Override
    public void findall() {
        salaryDao.findall();
    }

    @Override
    @Transactional
    public void save(SalaryDto salaryDto) {

        Salary salary=new Salary();
        BeanUtils.copyProperties(salaryDto,salary);
        salaryDao.save(salary);
    }
    public void insert(Long va1,String va2,String va3,float va4,float va5,float va6,float va7,float va8,float va9,float va10
            ,float va11,float va12,float va13,float va14,float va15,float va16,float va17,float va18,float va19
            ,float va20,float va21,float va22,float va23,float va24,float va25,float va26,float va27,float va28
            ,float va29,float va30,float va31){
        System.out.print("f\n");
        salaryDao.insert(va1,va2,va3,va4,va5,va6,va7,va8,va9,va10,va11,va12,va13,va14,va15,va16,va17,va18,va19
                ,va20,va21,va22,va23,va24,va25,va26,va27,va28,va29,va30,va31);
    }
    public String getstring(){
        return "";
    }
}
