package com.github.kylepeng93.common.shiro;

import com.github.kylepeng93.pojo.SysMenuPojo;
import com.github.kylepeng93.pojo.SysRolePojo;
import com.github.kylepeng93.pojo.SysUserPojo;
import com.github.kylepeng93.service.*;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * shiro权限匹配和帐号密码匹配
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-15 上午12:57
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 授权权限
     * 用户进行权限验证时候Shiro会去缓存中找,如果查不到数据,会执行这个方法去查权限,并放入缓存中
     * @Author Sans
     * @CreateTime 2019/6/12 11:44
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户ID
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUserPojo SysUserPojo = (SysUserPojo) principalCollection.getPrimaryPrincipal();
        Long userId =SysUserPojo.getUserId();
        //这里可以进行授权和处理
        Set<String> rolesSet = new HashSet<>();
        Set<String> permsSet = new HashSet<>();
        //查询角色和权限(这里根据业务自行查询)
        List<SysRolePojo> SysRolePojoList = sysRoleService.selectSysRoleByUserId(userId);
        for (SysRolePojo SysRolePojo:SysRolePojoList) {
            rolesSet.add(SysRolePojo.getRoleName());
            List<SysMenuPojo> SysMenuPojoList = sysMenuService.selectSysMenuByRoleId(SysRolePojo.getRoleId());
            for (SysMenuPojo SysMenuPojo :SysMenuPojoList) {
                permsSet.add(SysMenuPojo.getPerms());
            }
        }
        //将查到的权限和角色分别传入authorizationInfo中
        authorizationInfo.setStringPermissions(permsSet);
        authorizationInfo.setRoles(rolesSet);
        return authorizationInfo;
    }

    /**
     * 身份认证
     * @Author Sans
     * @CreateTime 2019/6/12 12:36
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户的输入的账号.
        String username = (String) authenticationToken.getPrincipal();
        //通过username从数据库中查找 User对象，如果找到进行验证
        //实际项目中,这里可以根据实际情况做缓存,如果不做,Shiro自己也是有时间间隔机制,2分钟内不会重复执行该方法
        SysUserPojo sysUserPojo = new SysUserPojo();
        sysUserPojo.setUsername(username);
        SysUserPojo user = sysUserService.selectUserConditional(sysUserPojo).stream()
                .max(Comparator.comparing(SysUserPojo::getUserId))
                .orElse(null);
        //判断账号是否存在
        if (user == null) {
            throw new AuthenticationException();
        }
        //判断账号是否被冻结
        if (user.getState()==null||user.getState().equals("PROHIBIT")){
            throw new LockedAccountException();
        }
        //进行验证
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,                                  //用户名
                user.getPassword(),                    //密码
                ByteSource.Util.bytes(user.getSalt()), //设置盐值
                getName()
        );
        //验证成功开始踢人(清除缓存和Session)
        ShiroUtils.deleteCache(username,true);
        return authenticationInfo;
    }
}
