package com.hyperchain.javase.threadpool.thread;


public class MyThread_Runable implements Runnable {
    private static int count = 20;

    @Override
    public synchronized void run() {

        for (int i = 0; i < count; i++) {
            System.out.println(Thread.currentThread().getName() + "卖出第：" + i + "张票");
        }
    }


    public static void main(String[] args) {
        // myThread类只生产一次 不存在线程安全问题
        MyThread_Runable myThread_runable = new MyThread_Runable();
        Thread mThread = new Thread(myThread_runable);
        Thread mThread2 = new Thread(myThread_runable);
        Thread mThread3 = new Thread(myThread_runable);
        mThread2.start();
        mThread.start();
        mThread3.start();
    }
}