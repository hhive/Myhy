package com.dmsoft.hyacinth.server.service;

import com.dmsoft.hyacinth.server.dto.EmailDto;

public interface EmailService {
    EmailDto findById(Long id);
}
