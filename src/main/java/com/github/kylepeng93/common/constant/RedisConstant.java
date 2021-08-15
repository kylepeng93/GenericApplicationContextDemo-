package com.github.kylepeng93.common.constant;

/**
 * redis相关的常量
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-15 上午12:35
 */
public class RedisConstant {
    /**
     * TOKEN前缀
     */
    public static final String REDIS_PREFIX_LOGIN = "login_token_%s";
    /**
     * 过期时间2小时
     */
    public static final Integer REDIS_EXPIRE_TWO = 7200;
    /**
     * 过期时间15分
     */
    public static final Integer REDIS_EXPIRE_EMAIL = 900;
    /**
     * 过期时间5分钟
     */
    public static final Integer REDIS_EXPIRE_KAPTCHA = 300;
    /**
     * 暂无过期时间
     */
    public static final Integer REDIS_EXPIRE_NULL = -1;

}
