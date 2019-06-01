/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Test
 * Author:   lixuanfeng
 * Date:     2019/6/1 上午10:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.java8.functionalInterface;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/1
 * @since 1.0.0
 */
public class Test {


    static String name = new String("absc");

    public static void main(String[] args) {
//        Runnable   函数是接口
//        Comparator 函数是接口

        IFunctional<String, Integer> integerIFunctional = new IFunctional<String, Integer>() {
            @Override
            public Integer handle(String s) {
                return Integer.parseInt(s);
            }
        };


        //使用lamada 表达式

        int a = 3 + 2;  //这样的才叫表达式  把匿名内部类的写法换成lamada表达式

        IFunctional<String, Integer> fun = s -> {
            return Integer.parseInt(s);
        };


//        IFunctional<String, Integer> fun = s -> Integer.parseInt(s);

        // 类（静态）方法引用
        // 1 当lamada表达式中只有一行代码 ，且是一个静态方法的时候，
        // 2 该静态方法接口的参数与我们函数是接口的抽象方法的参数一致，以及返回值也与函数是接口的抽象方法的返回值类型相同的时候
        // 可以使用lamada表达式来传递方法引用
        IFunctional<String, Integer> fun1 = Integer::parseInt;

        System.out.println(fun.handle("1223"));

// 对象方法的引用
//        IFunctional<String, Integer> iFunctional = name::indexOf;
//
//        System.out.println(iFunctional.handle("c"));


//        personFactory factory = ((firstname, lastname) -> new person(firstname, lastname));

// 构造方法的引用
        personFactory factory = person::new;
    }


    static class person {
        String firstname;
        String lastname;

        public person(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }
    }

    interface personFactory {
        person create(String firstname, String lastname);
    }
}