//package com.hyperchain.spring_boot.config.interceptors;
//
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import java.util.List;
//
///**
// * Created by superlee on 2017/11/3.
// * 配置自定义拦截器
// */
//@Configuration
//public class WebAppConfigurer extends WebMvcConfigurerAdapter {
//    @Value("${file.uploadUrl}")
//    private String uploadUrl;
//
//    //  @Autowired
//    //  private RequestTokenArgumentResolver requestTokenArgumentResolver;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
////        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**");
//        super.addInterceptors(registry);
//    }
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.PrettyFormat,
//                SerializerFeature.WriteMapNullValue,
//                SerializerFeature.DisableCircularReferenceDetect
//        );
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//
//        converters.add(fastConverter);
//    }
////    @Override
////    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
////        argumentResolvers.add(requestTokenArgumentResolver);
////        super.addArgumentResolvers(argumentResolvers);
////    }
//
//    //  @Override
////    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////
////
////        registry.addResourceHandler(File.separator + File.separator + BaseConstant.FOLDER_UPLOAD + "/**").
//////                addResourceLocations("classpath:/META-INF/resources/").
//////                addResourceLocations("classpath:/resources/").
//////                addResourceLocations("classpath:/public/").
////        addResourceLocations("file:" + uploadUrl + File.separator + File.separator + BaseConstant.FOLDER_UPLOAD + File.separator + File.separator);
////    }
//
//
//    /**
//     * 跨域
//     * @param registry
//     */
////    @Override
////    public void addCorsMappings(CorsRegistry registry) {
////        registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "OPTIONS", "PUT")
////                .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
////                        "Access-Control-Request-Headers")
////                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
////                .allowCredentials(true).maxAge(3600);
////    }
//}
