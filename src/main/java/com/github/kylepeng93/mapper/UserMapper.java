package com.github.kylepeng93.mapper;

import com.github.kylepeng93.pojo.UserPojo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    List<UserPojo> selectAll();

    int deleteByPrimaryKey(Integer id);

    int insert(UserPojo record);

    int insertSelective(UserPojo record);

    UserPojo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPojo record);

    int updateByPrimaryKey(UserPojo record);
}