package com.github.kylepeng93.config;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * 实现beanNameAware
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-09 下午11:05
 */
@Component
public class MyBeanName implements BeanNameAware {

    @Override
    public void setBeanName(String name) {
//        System.out.println("我是实现了BeanNameAware的自定义BeanName对象");
    }
}
