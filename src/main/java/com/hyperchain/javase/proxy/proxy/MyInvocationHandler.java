/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: MyInvocationHandler
 * Author:   lixuanfeng
 * Date:     2019/6/3 下午3:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.proxy.proxy;

import com.hyperchain.spring_boot.utils.MonitorUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/3
 * @since 1.0.0
 */
public class MyInvocationHandler<T> implements InvocationHandler {

    T target;


    public MyInvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行" + method.getName() + "方法");
        //代理过程中插入监测方法,计算该方法耗时
        MonitorUtil.start();
        Object result = method.invoke(target, args);
        MonitorUtil.finish(method.getName());
        return result;
    }
}