/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Test
 * Author:   lixuanfeng
 * Date:     2019/6/10 上午11:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.syntaxsugar.variable_arguments;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/10
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        test("sa", "sb", "ss", "ce");
    }

    public static void test(String... args) {
//        for-each的实现原理其实就是使用了普通的for循环和迭代器。
        for (String s : args) {
            System.out.println(s);
        }
    }
}