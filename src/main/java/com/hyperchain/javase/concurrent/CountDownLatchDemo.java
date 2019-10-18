/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: CountDownLatchDemo
 * Author:   lixuanfeng
 * Date:     2019/10/18 上午10:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.concurrent;

import com.hyperchain.javase.concurrent.enumvo.CountryEnum;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/10/18
 * @since 1.0.0
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "国灭亡！");
                countDownLatch.countDown();
            }, CountryEnum.getCountry(i).getCountryName()).start();
        }
        countDownLatch.await();
        System.out.println("六国灭亡，秦国统一天下！");
    }

}