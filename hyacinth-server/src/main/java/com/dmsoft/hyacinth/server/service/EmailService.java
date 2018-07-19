package com.dmsoft.hyacinth.server.service;

import com.dmsoft.hyacinth.server.dto.EmailDto;

public interface EmailService {
    EmailDto findid(Long id);
    void update(String email,String password,String emailtype,String post);
}
