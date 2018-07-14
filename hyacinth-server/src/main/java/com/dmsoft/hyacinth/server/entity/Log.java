package com.dmsoft.hyacinth.server.entity;

import com.dmsoft.bamboo.common.persistence.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name="t_log")
public class Log extends BaseEntity{
    private Date opera_time;
    private String opera_name;
    private String description;

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
