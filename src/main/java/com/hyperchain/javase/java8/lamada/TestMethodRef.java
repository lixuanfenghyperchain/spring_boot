/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: TestMethodRef
 * Author:   lixuanfeng
 * Date:     2019/6/2 下午3:16
 * Description: 测试方法引用
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.java8.lamada;

import java.io.PrintStream;
import java.util.function.Consumer;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试方法引用〉
 *
 * @author lixuanfeng
 * @create 2019/6/2
 * @since 1.0.0
 */
public class TestMethodRef {

    /**
     * 一： 方法引用：若lambda体中的内容有方法已经实现了，我们可以使用"方法引用"
     * （可以理解为方法引用是lambda表达式的另外一个写法）
     * <p>
     * 主要有三种语法格式
     * <p>
     * 对象::实列方法名
     * <p>
     * 类::静态方法名
     * <p>
     * 类::实列方法名
     * <p>
     * 注意：
     * 1  lambda体中调用方法的参数列表和返回值类型要和 函数式接口的抽象方法的参数列表和返回值类型保持一致
     * 2 lambda参数列表中的第一个参数是实列方法的调用者，第二个参数是实列方法的参数时，可以使用类名.实列方法名进行调用
     * <p>
     * <p>
     * <p>
     * <p>
     * 二：构造器引用
     * 类名::new
     */
    public static void main(String[] args) {


        Consumer<String> consumer = (x) -> System.out.println(x);

//        consumer.accept("你好");

//方法引用
        Consumer<String> consumer1 = System.out::println;

        consumer1.accept("hello world");

    }

}