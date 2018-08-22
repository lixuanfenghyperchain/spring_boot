///**
// * Copyright (C), 2016-2018, 趣链科技有限有限公司
// * FileName: LogAspect
// * Author:   lixuanfeng
// * Date:     2018/8/8 上午9:48
// * Description: 日志切面
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.hyperchain.spring_boot.aop;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Arrays;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈日志切面〉
// *
// * @author lixuanfeng
// * @create 2018/8/8
// * @since 1.0.0
// */
//@Aspect
//@Component
//public class LogAspect {
//
//    @Pointcut("execution(public * com.hyperchain.spring_boot.controller.*.*(..))")
//    public void webLog() {
//    }
//
//    @Before("webLog()")
//    public void doBeFore(JoinPoint joinPoint) throws Throwable {
//        // 接收到请求，记录请求内容
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = requestAttributes.getRequest();
//        // 记录下请求内容
//        System.out.println("URL : " + request.getRequestURL().toString());
//        System.out.println("HTTP_METHOD : " + request.getMethod());
//        System.out.println("IP : " + request.getRemoteAddr());
//        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));
//    }
//
//    @AfterReturning(returning = "ret", pointcut = "webLog()")
//    public void doAfterReturning(Object ret) throws Throwable {
//        // 处理完请求，返回内容
//        System.out.println("方法的返回值 : " + ret);
//    }
//
//    //后置异常通知
//    @AfterThrowing("webLog()")
//    public void throwss(JoinPoint jp) {
//        System.out.println("方法异常时执行.....");
//    }
//
//
//    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
//    @After("webLog()")
//    public void after(JoinPoint jp) {
//        System.out.println("方法最后执行.....");
//    }
//
//    //环绕通知,环绕增强，相当于MethodInterceptor
//    @Around("webLog()")
//    public Object arround(ProceedingJoinPoint pjp) {
//        System.out.println("方法环绕start.....");
//        try {
//            Object o = pjp.proceed(); //执行被切面的方法
//            System.out.println("方法环绕proceed，结果是 :" + o);
//            return o;
//        } catch (Throwable e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//
//}