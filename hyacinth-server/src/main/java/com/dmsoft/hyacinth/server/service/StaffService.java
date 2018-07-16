/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.service;

import com.dmsoft.hyacinth.server.dto.StaffDto;

import java.util.List;

public interface StaffService {

    StaffDto findById(Long id);

    List<StaffDto> findByCode(String code);
    List<StaffDto> findByName(String msg);
    List<StaffDto> findAll();
    void deltetall();
    void insert(long id,String code,String name,String position,String department,String phone,String email,String emdate);
}
