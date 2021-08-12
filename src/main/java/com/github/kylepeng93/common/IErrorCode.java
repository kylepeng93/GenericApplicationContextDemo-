package com.github.kylepeng93.common;

/**
 * https://kylepeng93.github.io
 * 封装API的错误码
 * @author pengkai
 * @date 2021-08-13 上午12:15
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
