package com.github.kylepeng93.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysMenuPojo implements Serializable {
    private Long menuId;

    private String name;

    private String perms;

    private static final long serialVersionUID = 1L;

}