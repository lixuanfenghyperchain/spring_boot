/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: ThreadPoolExecutorTest
 * Author:   lixuanfeng
 * Date:     2019/6/10 上午11:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.threadpool.thread_pool;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/10
 * @since 1.0.0
 */
public class ThreadPoolExecutorTest {


    /**
     * abort === 中止
     * ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。（默认handle）
     * <p>
     * Discard==丢弃
     * ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
     * <p>
     * ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
     * <p>
     * ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务。
     *
     * @param args
     */
    public static void main(String[] args) {

        /**
         * 1、CPU密集型：操作内存处理的业务，一般线程数设置为：CPU核数 + 1 或者 CPU核数*2。核数为4的话，一般设置 5 或 8
         *
         * 2、IO密集型：文件操作，网络操作，数据库操作，一般线程设置为：cpu核数 / (1-0.9)，核数为4的话，一般设置 40
         */
        int CPUCoreCount = Runtime.getRuntime().availableProcessors();

//        ExecutorService pool0 = new ThreadPoolExecutor(2, 4, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.AbortPolicy());
//        ExecutorService pool0 = new ThreadPoolExecutor(2, 4, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(5), (r, e) -> {
//            throw new RuntimeException("线程池已满，请稍后重试");
//        });
        ExecutorService pool1 = new ThreadPoolExecutor(CPUCoreCount * 4, CPUCoreCount * 8, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), new ThreadPoolExecutor.DiscardPolicy());
//        ExecutorService pool2 = new ThreadPoolExecutor(CPUCoreCount * 4, CPUCoreCount * 8, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), new ThreadPoolExecutor.DiscardOldestPolicy());
//        ExecutorService pool3 = new ThreadPoolExecutor(CPUCoreCount * 4, CPUCoreCount * 8, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());


//        for (int i = 0; i < 10000; i++) {
//            int index = i;
//            pool0.execute(() -> System.out.println("============" + index));
//        }


    }
}