package com.github.kylepeng93.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysRolePojo implements Serializable {
    private Long roleId;

    private String roleName;

    private static final long serialVersionUID = 1L;

}