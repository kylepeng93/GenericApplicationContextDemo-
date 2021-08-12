package com.github.kylepeng93.config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * 通用数据库连接配置
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-12 下午9:36
 */
public abstract class AbstractDatasourceConfig {

    // 允许自定义数据库配置
    public abstract DatabaseConfig databaseConfig();

    public DataSource getDataSource(DatabaseConfig databaseConfig) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // 使用bean自动注入属性值
        dataSource.setDriverClassName(databaseConfig.getDriverClassName());
        dataSource.setUrl(databaseConfig.getUrl());
        dataSource.setUsername(databaseConfig.getUserName());
        dataSource.setPassword(databaseConfig.getPassword());
        return dataSource;
    }
}
