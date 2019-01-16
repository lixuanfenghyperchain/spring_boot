package com.hyperchain.spring_boot.config.multipart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * 文件上传配置
 */
@Configuration
public class MultipartConfig {
    @Value("${file.uploadUrl}")
    private String uploadUrl;
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("20MB");
        factory.setMaxRequestSize("20MB");
        factory.setLocation(uploadUrl);
        return factory.createMultipartConfig();
    }

}
