package com.github.kylepeng93.service.impl;

import com.github.kylepeng93.mapper.SysRoleMenuMapper;
import com.github.kylepeng93.pojo.SysMenuPojoExample;
import com.github.kylepeng93.pojo.SysRoleMenuPojo;
import com.github.kylepeng93.pojo.SysRoleMenuPojoExample;
import com.github.kylepeng93.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-15 上午1:23
 */
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Autowired
    private SysRoleMenuMapper mapper;
    /**
     * 根据角色查询用户权限
     *
     * @param roleId
     * @Param roleId 角色ID
     * @Return List<SysRoleMenuPojo> 权限集合
     */
    @Override
    public List<SysRoleMenuPojo> selectSysMenuByRoleId(Long roleId) {
        SysRoleMenuPojoExample example = new SysRoleMenuPojoExample();
        SysRoleMenuPojoExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        return mapper.selectByExample(example);
    }
}
