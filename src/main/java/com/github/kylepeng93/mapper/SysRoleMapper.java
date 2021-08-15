package com.github.kylepeng93.mapper;

import com.github.kylepeng93.pojo.SysRolePojo;
import com.github.kylepeng93.pojo.SysRolePojoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMapper {
    long countByExample(SysRolePojoExample example);

    int deleteByExample(SysRolePojoExample example);

    int deleteByPrimaryKey(Long roleId);

    int insert(SysRolePojo record);

    int insertSelective(SysRolePojo record);

    List<SysRolePojo> selectByExample(SysRolePojoExample example);

    SysRolePojo selectByPrimaryKey(Long roleId);

    List<SysRolePojo> selectSysRoleByUserId(Long userId);

    int updateByExampleSelective(@Param("record") SysRolePojo record, @Param("example") SysRolePojoExample example);

    int updateByExample(@Param("record") SysRolePojo record, @Param("example") SysRolePojoExample example);

    int updateByPrimaryKeySelective(SysRolePojo record);

    int updateByPrimaryKey(SysRolePojo record);
}