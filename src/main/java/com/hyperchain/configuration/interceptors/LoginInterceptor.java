/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: LoginInterceptor
 * Author:   lixuanfeng
 * Date:     2019/6/14 上午10:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.configuration.interceptors;

import com.hyperchain.cache.Guava;
import com.hyperchain.service.TokenService;
import com.hyperchain.vo.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 * 登陆拦截器
 *
 * @author lixuanfeng
 * @create 2019/6/14
 * @since 1.0.0
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private Guava guava;


    /**
     *
     *分别实现预处理、后处理（调用了Service并返回ModelAndView，但未进行页面渲染）、返回处理（已经渲染了页面）
     *
     * 1.在preHandle中，可以进行编码、安全控制等处理；
     * 2.在postHandle中，有机会修改ModelAndView； 3.
     * 3.afterCompletion中，可以根据ex是否为null判断是否发生了异常，进行日志记录。
   */





    //这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取类名
//        System.out.println(((HandlerMethod) handler).getBean().getClass().getName());
        //获取方法名
//        System.out.println(((HandlerMethod) handler).getMethod().getName());


//        获取restful风格的url参数
//        Map<String, String> pathVariables = (Map<String, String>) request
//                .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
//        String lotCode = pathVariables.get("accessToken");

        //获取请求头中的token

        String accessToken = request.getHeader("access-token");

        Token token = tokenService.decodeToken(accessToken);
        String s = (String) guava.get("token:" + token.getUserId());
        if (null != s) {
            return true;
        } else {
            return false;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle 方法");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("afterCompletion 方法");
    }
}
