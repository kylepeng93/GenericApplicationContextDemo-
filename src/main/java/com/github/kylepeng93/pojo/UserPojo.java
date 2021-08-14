package com.github.kylepeng93.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserPojo implements Serializable {
    private Integer id;

    private String userName;

    private String password;

    private String gender;

    private String email;

    private static final long serialVersionUID = 1L;
}