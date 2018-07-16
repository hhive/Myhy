/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.service.impl;

import com.dmsoft.hyacinth.server.dao.LogDao;

import com.dmsoft.hyacinth.server.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;



@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public void insert(Long id,Date opera_time,String opera_name,String description){
        logDao.insert(id,opera_time,opera_name,description);
    }

}
