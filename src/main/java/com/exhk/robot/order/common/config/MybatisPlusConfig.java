package com.exhk.robot.order.common.config;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * @author Barry
 * @date 2017/10/29
 */
@Configuration
@MapperScan(basePackages= {"com.exhk.robot.order.dao","com.exhk.robot.order.mapper.**"})
@EnableTransactionManagement
public class MybatisPlusConfig {

    @Bean
    public PageHelper getPageHelper(){
        PageHelper pageHelper=new PageHelper();
        Properties properties=new Properties();
        properties.setProperty("helperDialect","mysql");
        properties.setProperty("reasonable","true");
        properties.setProperty("supportMethodsArguments","true");
        properties.setProperty("params","count=countSql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }

    /**
     * 分页插件
     *
     * @return PaginationInterceptor
     */
/*    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }*/

    /**
     * 数据权限插件
     *
     * @return DataScopeInterceptor
     */
//    @Bean
//    public DataScopeInterceptor dataScopeInterceptor() {
//        return new DataScopeInterceptor();
//    }
}
