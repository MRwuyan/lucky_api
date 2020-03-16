package com.exhk.robot.order.common.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

/**
 * 允许跨域 https
 * @author Barry
 * @create 2018-03-28 18:31
 **/

@Configuration
public class CustomCorsConfiguration {

    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        // 设置你要允许的网站域名，如果全允许则设为 *
        config.addAllowedOrigin("https://www.bit1.net");
        config.addAllowedOrigin("http://localhost:8080");
        config.addAllowedOrigin("https://localhost:8080");
        config.addAllowedOrigin("https://localhost:8081");
        config.addAllowedOrigin("http://localhost:8081");

        config.addAllowedOrigin("https://localhost:8081");
        config.addAllowedOrigin("http://localhost:8081");

        config.addAllowedOrigin("https://image.exhk.com");
        config.addAllowedOrigin("http://image.exhk.com");

        config.addAllowedOrigin("https://bit1.net");
        config.addAllowedOrigin("http://www.bit1.net");
        config.addAllowedOrigin("http://bit1.net");
        config.addAllowedOrigin("https://testpc.bit1.net");
        config.addAllowedOrigin("http://testpc.bit1.net");

        config.addAllowedOrigin("https://testadmin.bit1.net");
        config.addAllowedOrigin("http://testadmin.bit1.net");

        config.addAllowedOrigin("https://admin.bit1.net");
        config.addAllowedOrigin("http://admin.bit1.net");

        config.addAllowedOrigin("https://api.in-e.cn");
        config.addAllowedOrigin("http://api.in-e.cn");

        config.addAllowedOrigin("https://in-e.cn");
        config.addAllowedOrigin("http://in-e.cn");

        config.addAllowedOrigin("https://wn.in-e.cn");
        config.addAllowedOrigin("http://wn.in-e.cn");

        config.addAllowedOrigin("https://www.in-e.cn");
        config.addAllowedOrigin("http://www.in-e.cn");

        config.addAllowedOrigin("https://admin.in-e.cn");
        config.addAllowedOrigin("http://admin.in-e.cn");

        // 如果要限制 HEADER 或 METHOD 请自行更改
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        // 这个顺序很重要哦，为避免麻烦请设置在最前
        bean.setOrder(0);
        return bean;
    }
}
