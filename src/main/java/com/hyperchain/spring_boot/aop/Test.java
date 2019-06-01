/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Test
 * Author:   lixuanfeng
 * Date:     2019/3/26 上午11:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.aop;

import com.hyperchain.spring_boot.aop.annotation.MyAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/3/26
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) throws Exception {

        Class clazz = Class.forName("com.hyperchain.spring_boot.aop.UserMyAnnotation");
        UserMyAnnotation o = (UserMyAnnotation) clazz.newInstance();

        Method say = clazz.getMethod("say");
        say.invoke(o);


    }

}