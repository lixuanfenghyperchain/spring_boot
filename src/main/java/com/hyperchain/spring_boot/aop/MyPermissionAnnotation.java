/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: MyPermissionAnnotation
 * Author:   lixuanfeng
 * Date:     2018/8/31 下午3:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.aop;

import com.hyperchain.spring_boot.aop.annotation.Permission;
import com.hyperchain.spring_boot.vo.BaseResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/8/31
 * @since 1.0.0
 */
@Aspect
@Component
public class MyPermissionAnnotation {

    // 定义切点Pointcut
    @Pointcut("execution(* com.hyperchain.spring_boot.controller..*(..))")
    public void addAdvice() {
    }

    @Around("addAdvice()&& @annotation(permission)")
    public Object permissionAnnotation(ProceedingJoinPoint joinPoint, Permission permission) {
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println(args);
        }

        System.out.println(permission.value());

        try {
            return joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            BaseResult baseResult = new BaseResult();
            baseResult.setCode(1);
            return baseResult;
        }
    }
}