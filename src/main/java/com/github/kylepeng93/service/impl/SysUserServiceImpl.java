package com.github.kylepeng93.service.impl;

import com.github.kylepeng93.mapper.SysUserMapper;
import com.github.kylepeng93.pojo.SysUserPojo;
import com.github.kylepeng93.pojo.SysUserPojoExample;
import com.github.kylepeng93.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * 系统用户业务接口实现类
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-15 上午1:01
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    /**
     * 条件查询
     *
     * @param userPojo
     * @return
     */
    @Override
    public List<SysUserPojo> selectUserConditional(SysUserPojo userPojo) {
        SysUserPojoExample example = new SysUserPojoExample();
        SysUserPojoExample.Criteria criteria = example.createCriteria();
        if (userPojo != null) {
            if (userPojo.getUserId() != null) {
                criteria.andUserIdEqualTo(userPojo.getUserId());
            }
            if (StringUtils.isNotBlank(userPojo.getUsername())) {
                criteria.andUsernameEqualTo(userPojo.getUsername());
            }
            if (StringUtils.isNotBlank(userPojo.getState())) {
                criteria.andStateEqualTo(userPojo.getState());
            }
        }
        return sysUserMapper.selectByExample(example);
    }

    /**
     * 添加用户
     *
     * @param userPojo
     */
    @Override
    public Integer addUser(SysUserPojo userPojo) {
        if (userPojo == null) return null;
        return sysUserMapper.insertSelective(userPojo);
    }

    /**
     * 更新用户信息
     *
     * @param userPojo
     * @return
     */
    @Override
    public Integer updateUser(SysUserPojo userPojo) {
        if (userPojo == null || userPojo.getUserId() == null) return null;
        return sysUserMapper.updateByPrimaryKey(userPojo);
    }
}
