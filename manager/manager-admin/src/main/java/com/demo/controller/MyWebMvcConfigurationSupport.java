/**
 * 
 */
package com.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**   
 * @ClassName:  MyWebMvcConfigurationSupport   
 * @Description:TODO  springboot配置类
 * @author: xzr 
 * @date:   2019年4月24日 
 *     
 */
@Configuration // 表示这个类是一个配置类
@ImportResource(locations = { "applicationContext-kaptcha.xml" }) // 添加其它bean(验证码)
public class MyWebMvcConfigurationSupport extends WebMvcConfigurationSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyWebMvcConfigurationSupport.class);

  
    
    
    /*   
    * Title: addInterceptors
    * Description:  重写 WebMvcConfigurationSupport中 的 addInterceptors 方法，实现拦截器配置
    * addPathPatterns 添加拦截器规则
    * excludePathPatterns 用户访问拦截排除
    * @param registry   
    */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
	registry.addInterceptor(new MyHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/login",
		"/createCaptcha","/validateCaptcha","/**/images/**","/**/common/**","/**/css/**","/**/js/**");
	LOGGER.info("---addInterceptors方法----");
	super.addInterceptors(registry);
    }

    
    //自定义静态资源过滤
    /*   
     * Title: configureDefaultServletHandling   
     * Description:    
     * @param configurer   
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#configureDefaultServletHandling(org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer)   
     */  
    @Override
    protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	configurer.enable();
    }
    /*   
     * Title: addResourceHandlers   
     * Description: 重写父类    addResourceHandlers 方法，实现静态资源访问
     * addResourceHandler： 资源路径
     * addResourceLocations：表示所有资源会被解析为 /webapp/
     * @param registry   
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/webapp/").addResourceLocations("/webapp/");
	LOGGER.info("---addResourceHandlers方法----");
	super.addResourceHandlers(registry);
    }

    /*   
     * Title: addViewControllers   
     * Description:    重写addViewControllers 方法实现页面跳转
     * addViewController: 设置项目路径根路径
     * setViewName: 设置访问跟路径跳转的页面
     * @param registry   
     */
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
	registry.addViewController("/").setViewName("login");
	LOGGER.info("---addViewControllers方法----");
	super.addViewControllers(registry);
    }
}
