/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: UserAccessAspect
 * Author:   lixuanfeng
 * Date:     2018/8/8 上午10:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.aop;

import com.hyperchain.spring_boot.aop.annotation.UserAccess;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by wuwf on 17/4/27.
 */
@Component
@Aspect
public class UserAccessAspect {

    @Pointcut(value = "@annotation(com.hyperchain.spring_boot.aop.annotation.UserAccess)")
    public void access() {

    }

    @Before("access()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        System.out.println("second before");
    }

    @Around("@annotation(userAccess)")
    public Object around(ProceedingJoinPoint pjp, UserAccess userAccess) {
        Object[] args = pjp.getArgs();
        System.out.println(pjp.getSignature());
        System.out.println(pjp.getTarget());
        System.out.println(Arrays.toString(args));
        //获取注解里的值
        System.out.println("second around:" + userAccess.desc());
        try {
            return pjp.proceed(); //执行方法
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}
