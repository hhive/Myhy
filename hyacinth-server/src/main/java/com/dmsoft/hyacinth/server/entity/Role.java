/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.entity;

import com.dmsoft.bamboo.common.persistence.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 *  Created by Peter on 2016/7/11.
 */
@Entity
@Table(name = "t_role")
public class Role extends BaseEntity {

    private String code;
    private String description;

    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="rt_role_permission",joinColumns={@JoinColumn(name="role_id")},inverseJoinColumns={@JoinColumn(name="permission_id")})
    private List<Permission> permissions;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

}
