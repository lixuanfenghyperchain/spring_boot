///**
// * Copyright (C), 2016-2019, 趣链科技有限有限公司
// * FileName: MyTask
// * Author:   lixuanfeng
// * Date:     2019/4/13 上午10:18
// * Description:
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.hyperchain.javase.threadpool;
//
//import com.hyperchain.model.DonorDAF;
//import com.hyperchain.service.CharityService;
//
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈〉
// *
// * @author lixuanfeng
// * @create 2019/4/13
// * @since 1.0.0
// */
//public class MyTask implements Runnable {
//
//    public static int taskNum = 0;
//    private Lock lock = new ReentrantLock();
//
//
//    private DonorDAF donorDAF;
//
//
//    public MyTask(DonorDAF donorDAF) {
//        this.donorDAF = donorDAF;
//    }
//
//    @Override
//    public void run() {
//        CharityService.insertDonorDAF(donorDAF);
//        lock.lock();
//        MyTask.taskNum++;
//        lock.unlock();
//    }
//}