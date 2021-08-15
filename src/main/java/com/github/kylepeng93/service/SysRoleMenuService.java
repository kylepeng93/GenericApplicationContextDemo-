package com.github.kylepeng93.service;

import com.github.kylepeng93.pojo.SysRoleMenuPojo;

import java.util.List;

/**
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-15 上午1:21
 */
public interface SysRoleMenuService {

    /**
     * 根据角色查询用户权限
     * @Param  roleId 角色ID
     * @Return List<SysRoleMenuPojo> 权限集合
     */
    List<SysRoleMenuPojo> selectSysMenuByRoleId(Long roleId);
}
