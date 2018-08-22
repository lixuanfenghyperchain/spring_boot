/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: Test
 * Author:   lixuanfeng
 * Date:     2018/7/25 下午2:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.config.valid;

import org.springframework.util.Assert;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/7/25
 * @since 1.0.0
 */
public class Test {
    /**
     * 如果异常不捕获，则程序会中断执行
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("test exception");
        try {
            throw new RuntimeException("exception");
        } catch (RuntimeException rx) {
            System.out.println("捕获到运行时的异常");
        }
        System.out.println("fdsa");
        testAssert();
    }

    public static void testAssert() {
        String location = null;
        Assert.notNull(location, "Location must not be null");
        System.out.println("location = [" + location + "]");
    }
}