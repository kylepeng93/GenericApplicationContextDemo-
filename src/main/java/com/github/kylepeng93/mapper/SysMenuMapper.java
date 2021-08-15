package com.github.kylepeng93.mapper;

import com.github.kylepeng93.pojo.SysMenuPojo;
import com.github.kylepeng93.pojo.SysMenuPojoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMenuMapper {
    long countByExample(SysMenuPojoExample example);

    int deleteByExample(SysMenuPojoExample example);

    int deleteByPrimaryKey(Long menuId);

    int insert(SysMenuPojo record);

    int insertSelective(SysMenuPojo record);

    List<SysMenuPojo> selectByExample(SysMenuPojoExample example);

    SysMenuPojo selectByPrimaryKey(Long menuId);

    List<SysMenuPojo> selectSysMenuByRoleId(Long roleId);

    int updateByExampleSelective(@Param("record") SysMenuPojo record, @Param("example") SysMenuPojoExample example);

    int updateByExample(@Param("record") SysMenuPojo record, @Param("example") SysMenuPojoExample example);

    int updateByPrimaryKeySelective(SysMenuPojo record);

    int updateByPrimaryKey(SysMenuPojo record);
}