/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: ArrayBlockQueueDemo
 * Author:   lixuanfeng
 * Date:     2019/10/18 下午2:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.concurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/10/18
 * @since 1.0.0
 */
public class ArrayBlockQueueDemo {

    public static void main(String[] args) throws InterruptedException {
//        exceptionGroup();
//        booleanGroup();
//        blockGroup();
        autoGroup();

    }

    /**
     * 自动退出组   设置阻塞时间 到时自动退出
     *
     * @throws InterruptedException
     */
    private static void autoGroup() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);

        arrayBlockingQueue.offer("AAA", 2, TimeUnit.SECONDS);
        arrayBlockingQueue.offer("AAA", 2, TimeUnit.SECONDS);
        arrayBlockingQueue.offer("AAA", 2, TimeUnit.SECONDS);
//        arrayBlockingQueue.offer("AAA", 2, TimeUnit.SECONDS);  阻塞 2s 自动退出
        arrayBlockingQueue.poll(2, TimeUnit.SECONDS);
        arrayBlockingQueue.poll(2, TimeUnit.SECONDS);
        arrayBlockingQueue.poll(2, TimeUnit.SECONDS);
//        arrayBlockingQueue.poll(2, TimeUnit.SECONDS);
    }

    /**
     * 阻塞组  队列满或空时 一直阻塞
     *
     * @throws InterruptedException
     */
    private static void blockGroup() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);

        arrayBlockingQueue.put("AAA");
        arrayBlockingQueue.put("AAA");
        arrayBlockingQueue.put("AAA");
//        arrayBlockingQueue.put("AAA");   阻塞

        arrayBlockingQueue.take();
        arrayBlockingQueue.take();
        arrayBlockingQueue.take();
//        arrayBlockingQueue.take();
    }

    /**
     * 具有返回值型
     */
    private static void booleanGroup() {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);

        System.out.println(arrayBlockingQueue.offer("AAA"));
        System.out.println(arrayBlockingQueue.offer("AAA"));
        System.out.println(arrayBlockingQueue.offer("AAA"));
        System.out.println(arrayBlockingQueue.offer("AAA"));  //插入失败 返回false 不抛出异常

        System.out.println(arrayBlockingQueue.peek());           //探测队列头数据 没数据返回null

        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());         //取数据 无数据可取返回null
    }

    /**
     * 抛出异常型
     */
    private static void exceptionGroup() {
        //跑出异常组 常用方法  add   remove  element   队列满了再插入抛出：IllegalStateException: Queue full
        //队列如果为空再取数据：.NoSuchElementException
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
        for (int i = 0; i < 3; i++) {
            arrayBlockingQueue.add(i);
            System.out.println(arrayBlockingQueue);
        }
        // 返回队列第一个元素 如果为空 抛出NoSuchElementException
        System.out.println(arrayBlockingQueue.element());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
//        System.out.println(arrayBlockingQueue.remove());
    }


}