package com.github.kylepeng93.service.impl;

import com.github.kylepeng93.mapper.SysRoleMapper;
import com.github.kylepeng93.pojo.SysRolePojo;
import com.github.kylepeng93.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-15 上午10:48
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;
    /**
     * 查询用户id对应的系统角色
     * @param userId
     * @return
     */
    @Override
    public List<SysRolePojo> selectSysRoleByUserId(Long userId) {
        return sysRoleMapper.selectSysRoleByUserId(userId);
    }
}
