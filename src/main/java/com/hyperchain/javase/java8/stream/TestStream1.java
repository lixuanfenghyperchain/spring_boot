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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
public class TestStream1 {

    /**
     * 1 创建stream   1 通过集合的stream() 和paralleStream()  2 通过数组Arrays的静态方法stram()方法获取 3 通过Stream类的of()方法 4创建无限流
     * <p>
     * 2 中间操作
     * <p>
     * 3 终止操作
     */
    public static void main(String[] args) {

//1
        List<Integer> list = new ArrayList<>();
        Stream<Integer> stream = list.stream();

//2
        int[] ints = new int[6];

        IntStream stream1 = Arrays.stream(ints);

//3
        Stream<String> aa = Stream.of("aa", "bb");
//4 迭代
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);
        iterate.limit(10)
                .forEach(System.out::println);
        //4 生成

        Stream<Double> generate = Stream.generate(() -> Math.random() * 10);

        Stream<Double> limit = generate.limit(20);

    }

}