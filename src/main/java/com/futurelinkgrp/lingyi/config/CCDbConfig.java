package com.futurelinkgrp.lingyi.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by lchen on 8/25/2017.
 */
@Configuration
@EnableTransactionManagement
public class CCDbConfig {
    @Value("${cc.datasource.jndiname}")
    private String jndiName;

    @Bean(destroyMethod="", name="ccDataSource")
    public DataSource jndiDataSource() throws IllegalArgumentException, NamingException{
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName(jndiName);
        bean.setProxyInterface(DataSource.class);
        bean.setLookupOnStartup(false);
        bean.afterPropertiesSet();

        return (DataSource) bean.getObject();
    }


    @Bean(name = "ccTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("ccDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean(name = "ccSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("ccDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("come.futurelinkgrp.lingyi.domain");
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactoryBean.getObject();
    }


}
