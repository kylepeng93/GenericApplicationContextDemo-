package com.github.kylepeng93.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 自定义上下文
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-09 下午11:03
 */
@Component
public class MyApplicationContext implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("我是实现了ApplicationContextAware的自定义上下文");
    }
}
