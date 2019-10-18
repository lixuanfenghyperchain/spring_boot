/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: ProComsumer_BlockQueueDemo
 * Author:   lixuanfeng
 * Date:     2019/10/18 下午4:17
 * Description: 生产者消费者BlockQueue版本
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.concurrent.procom;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 〈一句话功能简述〉<br>
 * 〈生产者消费者BlockQueue版本〉
 *
 * @author lixuanfeng
 * @create 2019/10/18
 * @since 1.0.0
 */


class ShareDate {
    private boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    private BlockingQueue blockingQueue = null;

    public ShareDate(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    // 生产数据
    public void put() {
        String value;
        boolean offer;
        while (flag) {
            try {
                value = atomicInteger.getAndIncrement() + "";
                offer = blockingQueue.offer(value, 2, TimeUnit.SECONDS);
                if (offer) {
                    System.out.println(Thread.currentThread().getName() + "\t 插入队列成功" + value + "成功");
                } else {
                    System.out.println(Thread.currentThread().getName() + "\t 插入队列失败" + value + "失败");
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void get() {
        String result;
        while (flag) {
            try {
                result = (String) blockingQueue.poll(2, TimeUnit.SECONDS);
                if (null == result || result.equalsIgnoreCase("")) {
                    flag = false;
                    System.out.println(Thread.currentThread().getName() + "\t 超过2秒没有取到数据，消费退出");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "\t 消费" + result + "成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.flag = false;
    }
}


public class ProComsumer_BlockQueueDemo {

    public static void main(String[] args) {
        ShareDate shareDate = new ShareDate(new ArrayBlockingQueue(3));


        new Thread(() -> {
            shareDate.put();
        }, "AA").start();
        new Thread(() -> {
            shareDate.get();
        }, "BB").start();


        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("5秒之后，停止");
        shareDate.stop();
    }

}