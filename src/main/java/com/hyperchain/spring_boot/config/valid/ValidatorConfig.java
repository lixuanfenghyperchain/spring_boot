/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: ValidatorConfig
 * Author:   lixuanfeng
 * Date:     2018/7/24 下午6:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.config.valid;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/7/24
 * @since 1.0.0
 */
@Configuration
@EnableAutoConfiguration
public class ValidatorConfig {
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor(){
        return new MethodValidationPostProcessor();
    }
}
