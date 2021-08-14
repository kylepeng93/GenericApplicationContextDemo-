package com.github.kylepeng93.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * mybatis配置类
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-11 下午10:47
 */
@Configuration
@MapperScan("com.github.kylepeng93.mapper")
@EnableTransactionManagement
public class MybatisConfig {

    @Primary
    @Bean(value = "defaultDatasource", destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource defaultDatasource () throws SQLException {
       return DruidDataSourceBuilder.create().build();
    }

    /**
     * 注册web监控系统的相关配置
     * @return
     */
    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),
                "/druid/*");
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "1qaz2wsx33");
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    /**
     * 注册web监控系统的过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions",
                "*.js, *.gif, *.jpg, *.png, *.css, *.ico, /druid/*");
        return filterRegistrationBean;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("defaultDatasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 设置mapper.xml文件路径
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));
        // 设置pojo的全路径别名
        sqlSessionFactoryBean.setTypeAliasesPackage("com.github.kylepeng93.pojo");
        // 添加分页插件
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties props = new Properties();
        props.setProperty("helperDialect", "mysql");
        props.setProperty("supportMethodsArguments", "true");
        props.setProperty("rowBoundsWithCount", "true");
        pageInterceptor.setProperties(props);
        sqlSessionFactoryBean.setPlugins(pageInterceptor);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager txManager(@Qualifier("defaultDatasource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
