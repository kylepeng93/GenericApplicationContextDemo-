package com.github.kylepeng93.mapper;

import com.github.kylepeng93.pojo.SysUserPojo;
import com.github.kylepeng93.pojo.SysUserPojoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    long countByExample(SysUserPojoExample example);

    int deleteByExample(SysUserPojoExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(SysUserPojo record);

    int insertSelective(SysUserPojo record);

    List<SysUserPojo> selectByExample(SysUserPojoExample example);

    SysUserPojo selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") SysUserPojo record, @Param("example") SysUserPojoExample example);

    int updateByExample(@Param("record") SysUserPojo record, @Param("example") SysUserPojoExample example);

    int updateByPrimaryKeySelective(SysUserPojo record);

    int updateByPrimaryKey(SysUserPojo record);
}