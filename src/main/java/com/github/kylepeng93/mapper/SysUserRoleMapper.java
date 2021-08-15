package com.github.kylepeng93.mapper;

import com.github.kylepeng93.pojo.SysUserRolePojo;
import com.github.kylepeng93.pojo.SysUserRolePojoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserRoleMapper {
    long countByExample(SysUserRolePojoExample example);

    int deleteByExample(SysUserRolePojoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUserRolePojo record);

    int insertSelective(SysUserRolePojo record);

    List<SysUserRolePojo> selectByExample(SysUserRolePojoExample example);

    SysUserRolePojo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUserRolePojo record, @Param("example") SysUserRolePojoExample example);

    int updateByExample(@Param("record") SysUserRolePojo record, @Param("example") SysUserRolePojoExample example);

    int updateByPrimaryKeySelective(SysUserRolePojo record);

    int updateByPrimaryKey(SysUserRolePojo record);
}