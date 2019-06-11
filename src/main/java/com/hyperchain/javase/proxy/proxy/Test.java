/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Test
 * Author:   lixuanfeng
 * Date:     2019/6/3 下午3:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.proxy.proxy;

import com.hyperchain.javase.proxy.static_proxy.Person;
import com.hyperchain.javase.proxy.static_proxy.Student;

import java.lang.reflect.Proxy;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/3
 * @since 1.0.0
 */
public class Test {


    /**
     * 实现动态代理步骤
     * 1 Proxy.newProxyInstance(被代理类的接口类加载器，被代理类的接口的class文件数组，invocationHandler 实现类)
     * 2 编写 invocationHandler 实现类 重写invoke 方法，则可以在被调用的方法之前之后添加一些操作
     * 3 生成被代理的对象
     *
     * @param args
     */
    public static void main(String[] args) {

//        InvocationHandler invocationHandler = (proxy, method, args2) ->
//        {
//            System.out.println("代理执行" + method.getName() + "方法");
//            //代理过程中插入监测方法,计算该方法耗时
//            MonitorUtil.start();
//            Object result = method.invoke(proxy, args2);
//            MonitorUtil.finish(method.getName());
//            return result;
//        };

        MyInvocationHandler<Person> invocationHandler = new MyInvocationHandler<>(new Student());
        Person person = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, invocationHandler);
        Person person2 = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), Student.class.getInterfaces(), invocationHandler);
        person2.giveMoney(22);
        person.doHomeWork();
    }

}