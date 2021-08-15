package com.github.kylepeng93.mapper;

import com.github.kylepeng93.pojo.SysRoleMenuPojo;
import com.github.kylepeng93.pojo.SysRoleMenuPojoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMenuMapper {
    long countByExample(SysRoleMenuPojoExample example);

    int deleteByExample(SysRoleMenuPojoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRoleMenuPojo record);

    int insertSelective(SysRoleMenuPojo record);

    List<SysRoleMenuPojo> selectByExample(SysRoleMenuPojoExample example);

    SysRoleMenuPojo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRoleMenuPojo record, @Param("example") SysRoleMenuPojoExample example);

    int updateByExample(@Param("record") SysRoleMenuPojo record, @Param("example") SysRoleMenuPojoExample example);

    int updateByPrimaryKeySelective(SysRoleMenuPojo record);

    int updateByPrimaryKey(SysRoleMenuPojo record);
}