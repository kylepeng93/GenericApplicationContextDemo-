package com.github.kylepeng93.common;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-13 上午12:11
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    public CommonResponse handle(ApiException e) {
        if (e.getErrorCode() !=null) {
            return CommonResponse.failed(e.getErrorCode());
        }
        return CommonResponse.failed(e.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommonResponse handleValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        return handleBindMessage(bindingResult);
    }

    @ExceptionHandler(value = BindException.class)
    public CommonResponse handleValidException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        return handleBindMessage(bindingResult);
    }

    // 处理异常信息
    private CommonResponse handleBindMessage(BindingResult bindingResult) {
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField()+fieldError.getDefaultMessage();
            }
        }
        return CommonResponse.validateFailed(message);
    }

    @ExceptionHandler(value = Exception.class)
    public CommonResponse handleCommonException(Exception e) {
        return CommonResponse.failed(e.getMessage());
    }

    /**
     * 处理Shiro权限拦截异常
     * 如果返回JSON数据格式请加上 @ResponseBody注解
     * @Return Map<Object> 返回结果集
     */
    @ExceptionHandler(value = AuthorizationException.class)
    public CommonResponse authorizationErrorHandler(AuthorizationException e){
        return CommonResponse.forbidden(null);
    }

}
