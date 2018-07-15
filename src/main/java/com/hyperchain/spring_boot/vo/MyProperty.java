/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: MyProperty
 * Author:   lixuanfeng
 * Date:     2018/7/15 下午5:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/7/15
 * @since 1.0.0
 */
@Component
//@ConfigurationProperties(location= "classpath:config/my.properties", prefix = "my")
@Scope("prototype")
@PropertySource(value = "classpath:config/my.properties", encoding = "UTF-8")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyProperty {

    @Value("${name}")
    private String name;
    @Value("${age}")
    private String age;

}