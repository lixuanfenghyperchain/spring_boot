/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: SemaphoreDemo
 * Author:   lixuanfeng
 * Date:     2019/10/18 上午11:18
 * Description: 信号量demo
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈信号量demo〉
 *
 * @author lixuanfeng
 * @create 2019/10/18
 * @since 1.0.0
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        semaphore();
    }

    /**
     * 信号量 测试方法
     */
    private static void semaphore() {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t 抢到车位");
                    try { TimeUnit.SECONDS.sleep(3); } catch (Exception e) { e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName() + "\t 停车3秒后离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }

}