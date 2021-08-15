package com.github.kylepeng93.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUserRolePojo implements Serializable {
    private Long id;

    private Long userId;

    private Long roleId;

    private static final long serialVersionUID = 1L;

}