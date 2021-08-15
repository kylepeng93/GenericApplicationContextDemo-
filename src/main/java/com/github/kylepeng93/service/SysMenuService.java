package com.github.kylepeng93.service;

import com.github.kylepeng93.pojo.SysMenuPojo;

import java.util.List;

/**
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-15 上午10:45
 */
public interface SysMenuService {
    /**
     * 根据roleId查询系统目录
     * @param roleId
     * @return
     */
    List<SysMenuPojo> selectSysMenuByRoleId(Long roleId);
}
