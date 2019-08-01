/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: LocalDateTest
 * Author:   lixuanfeng
 * Date:     2019/7/22 下午3:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.java8.date;

import jdk.nashorn.api.scripting.ScriptUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/7/22
 * @since 1.0.0
 */
public class LocalDateTest {

    public static void main(String[] args) {
//        LocalDate localDate = LocalDate.now();
//        System.out.println(localDate);
//        System.out.println(localDate.getYear());
//        System.out.println(localDate.getMonthValue());
//        System.out.println(localDate.getDayOfMonth());
//
//
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy--MM--dd");
//        System.out.println(localDate.format(dateTimeFormatter));

//        Date date = new Date(2019, 00, -1);
//
//        System.out.println(date.getDate());
//        System.out.println(date.getMonth());
//        System.out.println(date.getYear());
//
//        // 直接获取到当前的时间毫秒值然后减去前一天的毫秒值 不就是前一天的时间吗
//        long currTime = new Date().getTime();
//        long oneDay = 1000 * 60 * 60 * 24;
//        long beforDayTime = currTime - oneDay;
//        new Date(beforDayTime);

        LocalDate localDate = LocalDate.of(2019, 1, 1);

        LocalDate yesterday = localDate.plusDays(-1);

        System.out.println(yesterday.getDayOfMonth());
        System.out.println(yesterday.getMonthValue());
        System.out.println(yesterday.getYear());
        LocalDate.parse("yyyy-MM-dd");
    }


}