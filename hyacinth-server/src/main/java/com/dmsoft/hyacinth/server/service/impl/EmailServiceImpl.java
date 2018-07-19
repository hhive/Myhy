package com.dmsoft.hyacinth.server.service.impl;

import com.dmsoft.hyacinth.server.dao.EmailDao;
import com.dmsoft.hyacinth.server.dto.EmailDto;
import com.dmsoft.hyacinth.server.entity.Email;
import com.dmsoft.hyacinth.server.service.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private EmailDao emailDao;

    @Override
    public EmailDto findById(Long id) {
        Email entity=emailDao.findById(id);
        EmailDto dto=new EmailDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public void update(String email, String password) {
        emailDao.update(email,password);
    }
}
