/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: ProdComsumer_TraditionDemo
 * Author:   lixuanfeng
 * Date:     2019/10/18 下午3:36
 * Description: 生产者消费者传统版本
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.concurrent.procom;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉<br>
 * 〈生产者消费者传统版本〉
 *
 * @author lixuanfeng
 * @create 2019/10/18
 * @since 1.0.0
 */

class ShareData {
    int num = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    /**
     * 加一操作
     */
    public void increment() {
        lock.lock();
        try {
            while (num != 0) {
                //等待
                condition.await();
            }
            //干活
            num++;
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 减一操作
     */
    public void decrement() {
        lock.lock();
        try {
            while (num == 0) {
                //等待
                condition.await();
            }
            //干活
            num--;
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}

/**
 * 初始值 num=0  A线程加一 然后B线程减一 循环5次
 */
public class ProdComsumer_TraditionDemo {


    public static void main(String[] args) {
        // 多线程操作共享资源类
        // 判断 干活 通知
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                shareData.increment();
                System.out.println(Thread.currentThread().getName() + "\t  加一 " + shareData.num);
                try { TimeUnit.SECONDS.sleep(1); } catch (Exception e) { e.printStackTrace(); }
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                shareData.decrement();
                System.out.println(Thread.currentThread().getName() + "\t  减一 " + shareData.num);
//                try { TimeUnit.SECONDS.sleep(1); } catch (Exception e) { e.printStackTrace(); }
            }
        }, "BB").start();

    }

}