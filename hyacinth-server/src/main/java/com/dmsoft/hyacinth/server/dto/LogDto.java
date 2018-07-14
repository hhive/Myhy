package com.dmsoft.hyacinth.server.dto;

import java.util.Date;

public class LogDto {
    private Long id;
    private Date opera_time;
    private String opera_name;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOpera_time() {
        return opera_time;
    }

    public void setOpera_time(Date opera_time) {
        this.opera_time = opera_time;
    }

    public String getOpera_name() {
        return opera_name;
    }

    public void setOpera_name(String opera_name) {
        this.opera_name = opera_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
