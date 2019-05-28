package com.demo.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan("com.demo.mapper") // 扫描dao
@ComponentScan({ "com.demo.server", "com.demo.controller" }) // 扫描server及controller
// @ImportResource(locations= {"applicationContext-kaptcha.xml"})//添加其它bean(验证码)
public class WebApplication {
    public static void main(String[] args) {
	SpringApplication.run(WebApplication.class, args);
    }

    @Bean
    public InternalResourceViewResolver ViewResolver() {
	InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	// 设置视图前缀
	resolver.setPrefix("/page/");
	resolver.setSuffix(".jsp");
	return resolver;
    }
}
