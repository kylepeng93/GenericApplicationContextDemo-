package com.github.kylepeng93.service;

import com.github.kylepeng93.pojo.SysUserRolePojo;

import java.util.List;

/**
 * https://kylepeng93.github.io
 * 系统角色信息接口
 * @author pengkai
 * @date 2021-08-15 上午1:10
 */
public interface SysUserRoleService {
    /**
     * 通过用户ID查询角色集合
     * @Param  userId 用户ID
     * @Return List<SysRolePojo> 角色名集合
     */
    List<SysUserRolePojo> selectSysRoleByUserId(Long userId);
}
