package com.github.kylepeng93.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysRoleMenuPojo implements Serializable {
    private Long id;

    private Long roleId;

    private Long menuId;

    private static final long serialVersionUID = 1L;

}