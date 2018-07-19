package com.dmsoft.hyacinth.server.service;

import com.dmsoft.hyacinth.server.dto.EmailDto;

public interface EmailService {
    EmailDto findById();
    void update(String email,String password,String emailtype,String post);
}
