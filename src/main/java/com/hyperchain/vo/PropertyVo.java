/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: PropertyVo
 * Author:   lixuanfeng
 * Date:     2019/6/11 下午7:30
 * Description: 读取application.properties配置文件数据到类的属性中
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈读取application.properties配置文件数据到类的属性中〉
 *
 * @author lixuanfeng
 * @create 2019/6/11
 * @PropertySource(value=”classpath:application.properties”) 指定配置文件路径
 * @ConfigurationProperties(prefix=”com.spring-boot”) 指定配置文件前缀  指定了前缀则属性名和配置文件的属性保持一致，并且要加上 setter 和 getter 方法。
 * 这样在项目启动的时候，SpringBoot 就会去加载对应配置文件中的属性，反射创建一个 bean 对象，并放入 Spring 的容器（ConcurrentHashMap）中，在需要使用的地方用 @Autowired 属性注入。
 */
@Component
public class PropertyVo {


    //用了@Value("${com.spring-boot.na}") 注解则不用保证属性名name和配置文件的属性一致
    @Value("${com.spring-boot.na}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}