/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: MyTokenArgumentResolver
 * Author:   lixuanfeng
 * Date:     2018/7/25 下午7:13
 * Description: 自定义方法参数拦截器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.config.interceptors;

import com.hyperchain.spring_boot.config.interceptors.token.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 〈一句话功能简述〉<br>
 * 〈自定义方法参数拦截器〉
 *
 * @author lixuanfeng
 * @create 2018/7/25
 * @since 1.0.0
 */
@Component
@Order(3)
@Slf4j
public class MyTokenArgumentResolver implements HandlerMethodArgumentResolver {
    // 接口方法说明：
    // supportsParameter：用于判定是否需要处理该参数，返回true为需要，并会去调用下面的方法resolveArgument。
    // resolveArgument：真正用于处理参数分解的方法，返回的Object就是controller方法上的形参对象。
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        //判断参数类型 以及是否有参数注解
        return methodParameter.getParameterType().equals(Token.class)
                //坑 了半天 方法写错了
                && methodParameter.hasParameterAnnotation(RequestToken.class);

    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        System.out.println("满足条件，进入参数处理方法");
        Token token = new Token();
        token.setId("tokenid");
        token.setName("name");
        token.setTime("20180801");
        token.setVersion("01");
        return token;
    }
}