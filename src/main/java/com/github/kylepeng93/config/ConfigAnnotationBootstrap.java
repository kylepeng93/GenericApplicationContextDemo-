package com.github.kylepeng93.config;

import com.github.kylepeng93.utils.ApplicationContextUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * 启动方法
 * https://kylepeng93.github.io
 * 验证beanPostProcessor方式的执行时机;
 * 结论：在bean初始化之前执行，
 * @author pengkai
 * @date 2021-08-09 下午9:57
 */
public class ConfigAnnotationBootstrap {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.scan("com.github.kylepeng93.config");
        ApplicationContextUtil.getBean("DBConnection");
//        context.refresh();
//        context.close();
    }
}
