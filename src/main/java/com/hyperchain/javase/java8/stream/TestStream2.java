/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: TestStream1
 * Author:   lixuanfeng
 * Date:     2019/6/2 下午4:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.java8.stream;

import com.hyperchain.javase.java8.lamada.vo.Employee;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/2
 * @since 1.0.0
 */
public class TestStream2 {


    static List<Employee> list = Arrays.asList(
            new Employee("张1", "23", 2221),
            new Employee("张2", "30", 3333),
            new Employee("张3", "44", 4444),
            new Employee("张4", "55", 5555),
            new Employee("张4", "55", 5555),
            new Employee("张4", "55", 5555)
    );


    /**
     * 1 创建stream   1 通过集合的stream() 和paralleStream()  2 通过数组Arrays的静态方法stram()方法获取 3 通过Stream类的of()方法 4创建无限流
     * <p>
     * 2 中间操作
     * <p>
     * 3 终止操作
     */

    public static void main(String[] args) {
        compare();
    }


    public static void square() {
        // 把数组中的每个元素求平方
        Integer[] integers = new Integer[]{1, 4, 6, 7};
        Arrays.stream(integers)
                .map((e) -> e * e)
                .forEach(System.out::println);
    }


    public static void sum() {
        Optional<Integer> reduce = list.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);
        System.out.println(reduce.get());
    }

    public static void filter() {
        PrintStream ps = System.out;
        ps.println("hello world");
        list.stream()
                .distinct()
                .filter(e -> e.getSalary() > 4000)
                //方法引用
                .forEach(TestStream2::say);
    }


    public static void compare() {
//        String s = "aaaaaab";
//        System.out.println(s.compareTo("aaa"));

        BiConsumer<String, String> biConsumer = (e, b) -> System.out.println(e + b);
        biConsumer.accept("lxf", "ysy");


        BiFunction<String, String, Integer> biFunction = String::compareTo;
        System.out.println(biFunction.apply("aaa", "bbb"));
    }

    public static void say(Employee s) {
        System.out.println("姓名： " + s.getName() + "  工资：  " + s.getSalary() + "  年龄： " + s.getAge());
    }
}