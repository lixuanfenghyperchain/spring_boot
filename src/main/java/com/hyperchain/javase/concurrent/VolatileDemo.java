/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: VolatileDemo
 * Author:   lixuanfeng
 * Date:     2019/10/18 上午8:39
 * Description: volatile关键字练习
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 〈一句话功能简述〉<br>
 * 〈volatile关键字练习〉
 *
 * @author lixuanfeng
 * @create 2019/10/18
 * @since 1.0.0
 */


public class VolatileDemo {

    AtomicInteger num = new AtomicInteger();

   static int num1 = 0;

    volatile boolean flag = false;


    public void add() {

        num.getAndIncrement();
    }

    public  static  synchronized void add1() {
        System.out.println(Thread.currentThread().getName() + "抢到资源 休息2秒钟");
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num1++;
    }

    public static synchronized void add2() {
        System.out.println(Thread.currentThread().getName() + "抢到资源 休息一秒钟");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num1++;
    }

    public void change() {
        flag = true;
    }

    public static void main(String[] args) throws InterruptedException {

        VolatileDemo volatileDemo = new VolatileDemo();

        new Thread(() -> {
            volatileDemo.add1();
        }, "AAA").start();


        VolatileDemo volatileDemo2 = new VolatileDemo();
        new Thread(() -> {
            volatileDemo2.add2();
        }, "BBB").start();


// 不保证原子性 验证
      /*  VolatileDemo volatileDemo = new VolatileDemo();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    volatileDemo.add();
                }
            }).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(volatileDemo.num);
        */


        //     ############### ############### ############### ###############
// 可见性验证
   /*     VolatileDemo volatileDemo = new VolatileDemo();
        new Thread(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            volatileDemo.change();
            System.out.println(Thread.currentThread().getId() + "  值已经改变" + volatileDemo.flag);
        }).start();

        while (!volatileDemo.flag) {

        }
        System.out.println("结束");
 */
    }
}
