/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: MyAdapter
 * Author:   lixuanfeng
 * Date:     2018/7/25 下午5:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.config.interceptors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * webmvc 配置适配器 比如配置拦截器  静态资源 方法参数拦截器等
 * 〈〉
 * web 配置
 *
 * @author lixuanfeng
 * @create 2018/7/25
 * @since 1.0.0
 */

//2.0 版本 webMvcConfigureaAdapter 过时
@Configuration
public class MyAdapter extends WebMvcConfigurerAdapter {

    /**
     * 拦截器 的配置
     *
     * @param registry
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //添加拦截器
//        registry.addInterceptor(new MyInterceptor())
//                .addPathPatterns("/user/**")
//                .excludePathPatterns("/css/**")
//                .excludePathPatterns("/js/**")
//                .excludePathPatterns("/images/**");
//        super.addInterceptors(registry);
//    }

    /**
     * 默认首页配置
     */
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("forward:/index");
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        super.addViewControllers(registry);
//    }

    /**
     * 自定义方法参数拦截器
     *
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new MyTokenArgumentResolver());
        super.addArgumentResolvers(argumentResolvers);
    }

    /**
     * 静态资源 虚拟路径配置
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")//映射之后能访问的路径
                .addResourceLocations("file:/Users/lixuanfeng/Desktop/testSource/");//资源原始路径  第一次测试不行 是没有加 file：
        super.addResourceHandlers(registry);
    }
}