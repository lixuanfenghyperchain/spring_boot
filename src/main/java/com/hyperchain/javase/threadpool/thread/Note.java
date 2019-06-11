/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Note
 * Author:   lixuanfeng
 * Date:     2019/6/5 上午10:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.threadpool.thread;

import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/5
 * @since 1.0.0
 */
public class Note {

    public static void main(String[] args) {
        /**
         * 创建线程的3种方式。
         * 什么是线程安全。
         * Runnable接口和Callable接口的区别。
         * wait方法和sleep方法的区别。  sleep 不会释放锁，时间结束自动加入等待队列，wait 会释放锁，需要被唤醒
         * synchronized、Lock、ReentrantLock、ReentrantReadWriteLock。
         * 介绍下CAS(无锁技术)。
         * volatile关键字的作用和原理。
         * 什么是ThreadLocal。
         * 创建线程池的4种方式。
         * ThreadPoolExecutor的内部工作原理。
         * 分布式环境下，怎么保证线程安全
         */
        //Executors.newFixedThreadPool(5); Executors.newSingleThreadExecutor();Executors.newCachedThreadPool(); Executors.newScheduledThreadPool();

    }

}