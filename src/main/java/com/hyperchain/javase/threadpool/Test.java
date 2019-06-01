///**
// * Copyright (C), 2016-2019, 趣链科技有限有限公司
// * FileName: Test
// * Author:   lixuanfeng
// * Date:     2019/4/13 上午10:27
// * Description:
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.hyperchain.javase.threadpool;
//
//
//
//import ccb.charity.model.DonorDAF;
//import ccb.charity.util.SingleThreadPool;
//
//import java.util.concurrent.ExecutorService;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈〉
// *
// * @author lixuanfeng
// * @create 2019/4/13
// * @since 1.0.0
// */
//public class Test {
//
//    public static void main(String[] args) {
//        ExecutorService executorService = SingleThreadPool.getInstance();
//
//        int taskNum = 200;
//        for (int i = 0; i < taskNum; i++) {
//            DonorDAF donorDAF = new DonorDAF("123" + i, "456", "we");
//            MyTask myTask = new MyTask(donorDAF);
//            executorService.execute(myTask);
//        }
//        EndTask endTask = new EndTask(taskNum);
//        executorService.execute(endTask);
//    }
//}