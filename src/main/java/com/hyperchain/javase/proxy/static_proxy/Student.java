/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Student
 * Author:   lixuanfeng
 * Date:     2019/6/3 下午2:43
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
public class Student implements Person {

    @Override
    public void giveMoney(double money) {
        System.out.println("上交班费： " + money);
    }

    @Override
    public void doHomeWork() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("做作业");
    }
}

