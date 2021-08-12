package com.github.kylepeng93.config;

import javax.sql.DataSource;

/**
 * 通用数据库连接配置
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-12 下午9:36
 */
public abstract class AbstractDatasourceConfig {
    public abstract DataSource dataSource();
}
