package com.github.kylepeng93.service.impl;

import com.github.kylepeng93.mapper.UserMapper;
import com.github.kylepeng93.pojo.UserPojo;
import com.github.kylepeng93.service.UserService;
import org.apache.catalina.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 用户信息服务Dao层实现类
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-14 上午12:06
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
    /**
     * 获取用户信息
     *
     * @return
     */
    @Override
    public List<UserPojo> getUsers() {
        return userMapper.selectAll();
    }

    /**
     * 添加用户
     *
     * @param userPojo
     */
    @Override
    public Integer addUser(UserPojo userPojo) {
        return userMapper.insertSelective(userPojo);
    }

    /**
     * 更新用户信息
     * @param userPojo
     * @return
     */
    @Override
    public Integer updateUser(UserPojo userPojo) {
        if (userPojo == null || StringUtils.isEmpty(userPojo.getId())) return null;
        return userMapper.updateByPrimaryKeySelective(userPojo);
    }
}
