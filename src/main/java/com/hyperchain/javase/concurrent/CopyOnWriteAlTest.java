/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: CopyOnWriteAlTest
 * Author:   lixuanfeng
 * Date:     2019/10/17 下午3:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.concurrent;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/10/17
 * @since 1.0.0
 */

class Cache {

    volatile Map<String, Object> cache = new HashMap<>();

    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    public void set(String key, Object value) {
        try {
            readWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "准备设值" + key);
            cache.put(key, value);
            try {
                TimeUnit.MILLISECONDS.sleep(300L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("设值完成");
            readWriteLock.writeLock().unlock();
        } catch (Exception e) {
            readWriteLock.writeLock().unlock();
        }
    }


    public void get(String key) {
        try {
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "准备获取值" + key);
            try {
                TimeUnit.MILLISECONDS.sleep(300L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("获取完成" + cache.get(key));
            readWriteLock.readLock().unlock();
        } catch (Exception e) {
            readWriteLock.readLock().unlock();
        }
    }
}

public class CopyOnWriteAlTest {


    public static void main(String[] args) throws InterruptedException {
        Cache cache = new Cache();
        for (int i = 1; i < 10; i++) {
            final int tem = i;
            new Thread(() -> {
                cache.set(tem + "", "," + tem);
            }, String.valueOf(tem)).start();
        }
        try {
            TimeUnit.MILLISECONDS.sleep(3000L);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 1; i < 10; i++) {
            final int tem = i;
            new Thread(() -> {
                cache.get(tem + "");
            }, String.valueOf(tem)).start();
        }


    }
}