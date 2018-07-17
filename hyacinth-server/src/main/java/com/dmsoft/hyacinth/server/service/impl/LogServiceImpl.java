/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.service.impl;

import com.dmsoft.hyacinth.server.dao.LogDao;

import com.dmsoft.hyacinth.server.dto.LogDto;
import com.dmsoft.hyacinth.server.entity.Log;
import com.dmsoft.hyacinth.server.service.LogService;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;
    @Override
    public List<LogDto> findAll() {
        Iterable<Log> entityList = logDao.findAll();

        List<LogDto> list = Lists.newArrayList();

        entityList.forEach(entity -> {
            LogDto dto = new LogDto();
            BeanUtils.copyProperties(entity, dto);
            list.add(dto);
        });

        return list;
    }

    @Override
    public void insert(Long id,Date opera_time,String opera_name,String description){
        logDao.insert(id,opera_time,opera_name,description);
    }

}
