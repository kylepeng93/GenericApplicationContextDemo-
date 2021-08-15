package com.github.kylepeng93.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUserPojo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private String username;

    private String password;

    private String salt;

    private String state;
}