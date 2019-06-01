/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: TestLamada
 * Author:   lixuanfeng
 * Date:     2019/6/1 上午10:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.java8.lamada;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/1
 * @since 1.0.0
 */
public class TestLamada {

    public static void main(String[] args) {
        // lamada 表达式只是匿名内部类的一种写法
        //本质：匿名内部类会隐式的继承一个类或者实现一个接口，或者说，匿名内部类是一个继承了该类或者实现了该接口的子类匿名对象。
        // 匿名内部类是一个对象

//        new Thread() {
//            @Override
//            public void run() {
//                super.run();
//            }
//        };
//
//      两个匿名内部类
//
//        new Comparator<String>(){
//
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        };

        List<String> list = Arrays.asList("m", "b", "v");

        //原始写法 , 使用匿名内部类 实现比较器
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Collator.getInstance().compare(o1, o2);
            }
        });


//        使用lamada 表达式进行改造，前提是该接口必须是 函数是接口
//       (String o1, String o2) 这是该函数是接口的抽象方法的参数
        Collections.sort(list, (String o1, String o2) -> {
            return Collator.getInstance().compare(o1, o2);
        });

//        //当函数体只有一行代码 我们可以去掉{} 和return关键字
        Collections.sort(list, (String o1, String o2) -> Collator.getInstance().compare(o1, o2));
//        //自动类型推导
        Collections.sort(list, (o1, o2) -> Collator.getInstance().compare(o1, o2));
//        System.out.println(list);
    }

}