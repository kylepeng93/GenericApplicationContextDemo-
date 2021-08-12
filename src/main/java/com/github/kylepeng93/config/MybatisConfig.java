package com.github.kylepeng93.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
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
public class MybatisConfig extends AbstractDatasourceConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean(value = "defaultDatasource")
    @Primary
    public DataSource dataSource () {
       DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
       driverManagerDataSource.setDriverClassName(driverClassName);
       driverManagerDataSource.setUrl(url);
       driverManagerDataSource.setUsername(userName);
       driverManagerDataSource.setPassword(password);
       return driverManagerDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("defaultDatasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.github.kylepeng93.pojo");
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
}
