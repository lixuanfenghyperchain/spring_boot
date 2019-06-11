/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: DubbleSingleton
 * Author:   lixuanfeng
 * Date:     2018/10/16 下午3:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.design.singleton;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/10/16
 * @since 1.0.0
 */
public class DubbleSingleton {
    private static DubbleSingleton ds;

    public static DubbleSingleton getDs() {
        if (ds == null) {
            try {
                //模拟初始化对象的准备时间...
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (DubbleSingleton.class) {
                if (ds == null) {
                    ds = new DubbleSingleton();
                }
            }
        }
        return ds;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(DubbleSingleton.getDs().hashCode());
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(DubbleSingleton.getDs().hashCode());
            }
        }, "t2");


        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(DubbleSingleton.getDs().hashCode());
            }
        }, "t3");

        t1.start();
        t2.start();
        t3.start();
    }

}