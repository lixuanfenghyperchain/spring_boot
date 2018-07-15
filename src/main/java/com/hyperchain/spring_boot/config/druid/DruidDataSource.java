///**
// * Copyright (C), 2016-2018, 趣链科技有限有限公司
// * FileName: DruidDataSource
// * Author:   lixuanfeng
// * Date:     2018/7/15 下午11:08
// * Description:
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.hyperchain.spring_boot.config.druid;
//
//
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈〉
// *
// * @author lixuanfeng
// * @create 2018/7/15
// * @since 1.0.0
// */
//@Configuration
//@ConditionalOnClass(com.alibaba.druid.pool.DruidDataSource.class)
//@ConditionalOnProperty(name = "spring.datasource.type", havingValue = "com.alibaba.druid.pool.DruidDataSource", matchIfMissing = true)
//public class DruidDataSource {
//
//    /**
//     * @return DruidDataSource
//     * @see
//     */
//    @Bean
//    @ConfigurationProperties("spring.datasource.druid")
//    public DataSource dataSourceOne() {
//        return DruidDataSourceBuilder.create().build();
//    }
//
//    /**
//     * 注册一个StatViewServlet
//     *
//     * @return
//     */
//    /*
//    @Bean
//    public ServletRegistrationBean druidStatViewServlet() {
//        //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//        //添加初始化参数：initParams
//        //白名单：
//        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
//        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
//        servletRegistrationBean.addInitParameter("deny", "192.168.1.73");
//        //登录查看信息的账号密码.
//        servletRegistrationBean.addInitParameter("loginUsername", "admin");
//        servletRegistrationBean.addInitParameter("loginPassword", "123456");
//        //是否能够重置数据.
//        servletRegistrationBean.addInitParameter("resetEnable", "false");
//        return servletRegistrationBean;
//    }
//
//    /**
//     * 注册一个：filterRegistrationBean
//     *
//     * @return
//     */
//    /*
//    @Bean
//    public FilterRegistrationBean druidStatFilter() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
////添加过滤规则.
//        filterRegistrationBean.addUrlPatterns("/*");
//        //添加不需要忽略的格式信息.
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }
//*/
//}