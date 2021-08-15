package com.github.kylepeng93.domain.userManagement.dto;

import com.github.kylepeng93.pojo.SysUserPojo;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

/**
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-15 下午1:27
 */
@Data
public class SysUserDto {
    private Integer userId;

    private String userName;

    private String state;

    public static SysUserDto convert(SysUserPojo user) {
        if (user == null) return null;
        SysUserDto sysUserDto = new SysUserDto();
        BeanUtils.copyProperties(user,sysUserDto);
        return sysUserDto;
    }
}
