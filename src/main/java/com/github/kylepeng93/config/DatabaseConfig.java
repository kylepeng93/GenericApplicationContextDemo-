package com.github.kylepeng93.config;

import lombok.Data;

import java.sql.Connection;

/**
 * 数据库配置
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-09 下午10:47
 */
@Data
public class DatabaseConfig {

    private static Connection connection;

    private String driverName;
    private String url;
    private String userName;
    private String password;

    public DatabaseConfig(String driverName, String url, String userName, String password) {
        this.driverName = driverName;
        this.url = url;
        this.userName = userName;
        this.password = password;
        System.out.println("构造连接参数...");
    }

    public void init() {
        System.out.println("初始化数据库连接");
    }

    public void destroy() {
        System.out.println("销毁数据库连接");
    }

}
