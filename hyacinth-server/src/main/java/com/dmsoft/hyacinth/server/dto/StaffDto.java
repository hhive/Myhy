/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.dto;

import com.dmsoft.bamboo.common.dto.AbstractValueObject;

public class StaffDto extends AbstractValueObject {

    private Long id;
    private String code;
    private String name;
    private String position;
    private String department;
    private String phone;
    private String email;
    private String emdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmdate() {
        return emdate;
    }

    public void setEmdate(String emdate) {
        this.emdate = emdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getString(){
        return id+"\t"+code+"\t"+name+"\t"+position+"\t"+department+"\t"+phone+"\t"+email+"\t"+emdate+"\n";
    }

}
