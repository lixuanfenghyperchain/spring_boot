/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: MyThread_Thread
 * Author:   lixuanfeng
 * Date:     2019/6/18 下午7:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.threadpool.thread;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/18
 * @since 1.0.0
 */
public class MyThread_Thread extends Thread {

    private boolean isRuning = true;

    @Override
    public void run() {
        System.out.println("进入run方法..");
        while (isRuning == true) {
        }
        System.out.println("线程停止");
    }

    private void setRunning(boolean isRunning) {
        this.isRuning = isRunning;
    }


    public static void main(String[] args) throws InterruptedException {
        MyThread_Thread vt = new MyThread_Thread();
        vt.start();
        Thread.sleep(3000);
        vt.setRunning(false);
        System.out.println("isRunning的值已经被设置了false");
        Thread.sleep(1000);
        System.out.println(vt.isRuning);
    }


//
//    public static void main(String[] args) throws InterruptedException {
//        MyThread_Thread vt = new MyThread_Thread();
//        vt.start();
//        Thread.sleep(3000);
//        vt.setRunning(false);
//        System.out.println("isRunning的值已经被设置了false");
//        Thread.sleep(1000);
//        System.out.println(vt.isRunning);
//    }


}