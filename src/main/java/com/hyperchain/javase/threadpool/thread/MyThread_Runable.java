package com.hyperchain.javase.threadpool.thread;


public class MyThread_Runable implements Runnable {
    private static volatile int count = 100;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (count > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖出第：" + count + "张票");
                count--;
            }
        }
    }


    public static void main(String[] args) {
        // myThread类只生产一次 不存在线程安全问题
        MyThread_Runable myThread_runable = new MyThread_Runable();
        Thread mThread = new Thread(myThread_runable);
        Thread mThread2 = new Thread(myThread_runable);
        Thread mThread3 = new Thread(myThread_runable);
        Thread mThread4 = new Thread(myThread_runable);
        Thread mThread5 = new Thread(myThread_runable);
        Thread mThread6 = new Thread(myThread_runable);
        mThread.start();
        mThread2.start();
        mThread3.start();
        mThread4.start();
        mThread5.start();
        mThread6.start();
    }
}