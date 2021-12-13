package com.github.kylepeng93.common.filter;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kylepeng93.common.CommonResponse;
import com.github.kylepeng93.common.ResultCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.tomcat.util.http.ResponseUtil;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * shiro认证失败后直接返回错误信息
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-15 下午4:12
 */
public class RestAuthorizationFilter extends FormAuthenticationFilter {
    /**
     * Convenience method merely delegates to
     * {@link WebUtils#saveRequest(ServletRequest) WebUtils.saveRequest(request)} to save the request
     * state for reuse later.  This is mostly used to retain user request state when a redirect is issued to
     * return the user to their originally requested url/resource.
     * <p/>
     * If you need to save and then immediately redirect the user to login, consider using
     * {@link #saveRequestAndRedirectToLogin(ServletRequest, ServletResponse)
     * saveRequestAndRedirectToLogin(request,response)} directly.
     *
     * @param request the incoming ServletRequest to save for re-use later (for example, after a redirect).
     */
    @Override
    protected void saveRequest(ServletRequest request) {
        super.saveRequest(request);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        //获取认证主
        Subject subject = SecurityUtils.getSubject();
        //已经认证 就直接放行
        if (subject.isAuthenticated()){
            return true;
        } else {
            response.getWriter().print(JSON.toJSONString(CommonResponse.failed(ResultCode.UNAUTHORIZED)));
        }
        return false;
    }
}
