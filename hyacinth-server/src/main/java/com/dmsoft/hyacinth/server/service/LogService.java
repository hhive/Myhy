/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.service;

import com.dmsoft.hyacinth.server.dto.LogDto;
import com.dmsoft.hyacinth.server.dto.StaffDto;

import java.util.Date;
import java.util.List;

public interface LogService {
    List<LogDto> findAll();
    void insert(Long id,Date opera_time, String opera_name, String description);
}
