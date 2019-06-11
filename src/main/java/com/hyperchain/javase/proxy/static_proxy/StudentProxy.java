/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: StudentProxy
 * Author:   lixuanfeng
 * Date:     2019/6/3 下午2:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.proxy.static_proxy;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/3
 * @since 1.0.0
 */
public class StudentProxy implements Person {

    Student student;


    public StudentProxy(Person person) {
        if (person.getClass() == Student.class) {
            this.student = (Student) person;
        } else {
            System.out.println("该对象不能被代理");
        }
    }

    @Override
    public void giveMoney(double money) {
        student.giveMoney(20);
    }

    @Override
    public void doHomeWork() {
        student.doHomeWork();
    }
}