/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.service.impl;

import com.dmsoft.hyacinth.server.dao.StaffDao;
import com.dmsoft.hyacinth.server.dto.StaffDto;
import com.dmsoft.hyacinth.server.entity.Staff;
import com.dmsoft.hyacinth.server.service.StaffService;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Peter Li on 2017/12/15.
 */
@Service
public  class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;

    @Override
    public List<StaffDto> findAll() {
        Iterable<Staff> entityList = staffDao.
                findAll();

        List<StaffDto> list = Lists.newArrayList();

        entityList.forEach(entity -> {
            StaffDto dto = new StaffDto();
            BeanUtils.copyProperties(entity, dto);
            list.add(dto);
        });

        return list;
    }

    @Override
    public StaffDto findById(Long id) {
        Staff entity = staffDao.findById(id);
        StaffDto dto = new StaffDto();
        BeanUtils.copyProperties(entity, dto);

        return dto;
    }

    @Override
    public List<StaffDto> findByName(String msg) {
        Iterable<Staff> entityList = staffDao.findByName(msg);
        List<StaffDto> list = Lists.newArrayList();

        entityList.forEach(entity -> {
            StaffDto dto = new StaffDto();
            BeanUtils.copyProperties(entity, dto);
            list.add(dto);
        });

        return list;
    }


    @Override
    public List<StaffDto> findByCode(String code) {
        Staff entity = staffDao.findByCode(code);

        List<StaffDto> list = Lists.newArrayList();
        StaffDto dto = new StaffDto();
        if(!(entity==null))
        {BeanUtils.copyProperties(entity, dto);list.add(dto);}
        else return null;
        return list;
    }

    @Override
    public  StaffDto findcode(String code){
        Staff entity =staffDao.findByCode(code);
        StaffDto dto = new StaffDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
    @Override
    public void insert(long id,String code,String name,String position,String department,String phone,String email,String emdate){
        staffDao.insert(id, code, name, position, department, phone, email, emdate);
    }

    @Override
    public void deltetall() {
        staffDao.deleteAll();
    }

}
