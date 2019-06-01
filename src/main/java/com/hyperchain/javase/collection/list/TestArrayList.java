/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: TestArrayList
 * Author:   lixuanfeng
 * Date:     2019/5/28 下午10:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.collection.list;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/5/28
 * @since 1.0.0
 */
public class TestArrayList {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // jdk 1.8 数组集合扩容机制  当达到目前的最大容量的时候
        // int newCapacity = oldCapacity + (oldCapacity >> 1);   新容量=目前容量+目前容量/2
        //
        List<Integer> squares = new ArrayList<>();

        for (int i = 0; i < 16; i++) {
            squares.add(i);
        }

        Integer set = squares.set(1, 100);


//        Class aClass = squares.getClass();
//
//        Field f;
//
//        f = aClass.getDeclaredField("elementData");
//
//        f.setAccessible(true);
//        Object[] o = (Object[]) f.get(squares);
//        System.out.println(o.length);
    }
}