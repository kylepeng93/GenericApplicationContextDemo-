package com.github.kylepeng93.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.sql.DataSource;

/**
 * 数据库配置
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-09 下午10:47
 */
@Data
public class DatabaseConfig {
    private String driverClassName;
    private String url;
    private String userName;
    private String password;
}
