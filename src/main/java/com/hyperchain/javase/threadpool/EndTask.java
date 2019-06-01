///**
// * Copyright (C), 2016-2019, 趣链科技有限有限公司
// * FileName: EndTask
// * Author:   lixuanfeng
// * Date:     2019/4/13 上午10:23
// * Description:
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.hyperchain.javase.threadpool;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈〉
// *
// * @author lixuanfeng
// * @create 2019/4/13
// * @since 1.0.0
// */
//public class EndTask implements Runnable {
//
//    private int tnum = 0;
//
//    public EndTask(int tnum) {
//        this.tnum = tnum;
//    }
//
//    @Override
//    public void run() {
//
//        try {
//            while (true) {
//                if (tnum == MyTask.taskNum) {
//                    System.out.println("开始执行最终任务");
//                    break;
//
//                } else {
//                    System.out.println("线程池的任务没有完成，等待。。。");
//                    Thread.sleep(3000);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//    }
//
//}