/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.entity;

import javax.persistence.Table;

/**
 * UserEntity:
 *
 * @author yangbo
 * @version 1.00
 * @since 2018/1/24 0024 17:54
 */
@Table(name = "test", schema = "test")
public class UserEntity {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
