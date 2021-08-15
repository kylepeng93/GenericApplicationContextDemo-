package com.github.kylepeng93.service.impl;

import com.github.kylepeng93.mapper.SysUserRoleMapper;
import com.github.kylepeng93.pojo.SysUserRolePojo;
import com.github.kylepeng93.pojo.SysUserRolePojoExample;
import com.github.kylepeng93.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * https://kylepeng93.github.io
 * 系统角色信息接口实现类
 * @author pengkai
 * @date 2021-08-15 上午1:11
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    /**
     * 通过用户ID查询角色集合
     *
     * @param userId
     * @Param userId 用户ID
     * @Return List<SysRoleEntity> 角色名集合
     * @return
     */
    @Override
    public List<SysUserRolePojo> selectSysRoleByUserId(Long userId) {
        SysUserRolePojoExample example = new SysUserRolePojoExample();
        SysUserRolePojoExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return sysUserRoleMapper.selectByExample(example);
    }
}
