/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: StackOutOfMemory
 * Author:   lixuanfeng
 * Date:     2018/11/12 下午9:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.test;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/11/12
 * @since 1.0.0
 */
//ava.lang.StackOverflowError
public class StackOutOfMemory {
    public static void test() {
        test();
    }
    public static void main(String[] args) {
        StackOutOfMemory.test();
    }
}