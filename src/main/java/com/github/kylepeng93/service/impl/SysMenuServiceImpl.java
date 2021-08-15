package com.github.kylepeng93.service.impl;

import com.github.kylepeng93.mapper.SysMenuMapper;
import com.github.kylepeng93.pojo.SysMenuPojo;
import com.github.kylepeng93.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-15 上午10:47
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;
    /**
     * 根据roleId查询系统目录
     *
     * @param roleId
     * @return
     */
    @Override
    public List<SysMenuPojo> selectSysMenuByRoleId(Long roleId) {
        return sysMenuMapper.selectSysMenuByRoleId(roleId);
    }
}
