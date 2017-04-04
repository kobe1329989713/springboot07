package com.utsoft.pring.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * <br />日期：2017/4/4
 * <br />时间：21:23
 * <br />创建人：刘坤
 * <br />描述：
 * 使用自己配置的数据源、之使用阿里的哪个 druxx 什么数据源
 */
@SpringBootConfiguration
public class DBCongiguration {

    // 从配置文件里面获取 下面需要的参数。
    @Autowired
    private Environment env;

    @Bean
    public DataSource createDataSource(){
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl(env.getProperty("spring.datasource.url"));
        ds.setUsername(env.getProperty("spring.datasource.username"));
        ds.setPassword(env.getProperty("spring.datasource.password"));
        ds.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        return ds;
    }
}
