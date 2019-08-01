/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: ExecutorsUtil
 * Author:   lixuanfeng
 * Date:     2019/4/9 下午1:20
 * Description: 线程池工具
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.util;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈线程池工具〉
 * 单列线程池
 *
 * @author lixuanfeng
 * @create 2019/4/9
 * @since 1.0.0
 */
public class SingleThreadPool {
    private SingleThreadPool() {
    }

    private static class ThreadPoolInstance

    {
        private static final int CPUCoreCount = Runtime.getRuntime().availableProcessors();

        private static final ExecutorService pool = new ThreadPoolExecutor(CPUCoreCount * 4,CPUCoreCount * 8,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(1024));
//        private static final ExecutorService poolExam =   Executors.newFixedThreadPool(20);
    }

    public static ExecutorService getInstance() {
        return ThreadPoolInstance.pool;
    }
}