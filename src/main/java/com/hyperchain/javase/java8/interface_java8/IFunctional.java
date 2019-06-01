package com.hyperchain.javase.java8.interface_java8;

public interface IFunctional {


    // 此接口就可以作为函数是接口 ，使用lamada表达式的写法
    void method(String from);


    //java 8  使用默认方法和静态方法这两个概念来扩展接口的声明

    // 同时兼容旧版本，默认方法与抽象方法不同之处在于：抽象方法必须要求实现，默认方法没有这个要求
    // 必须提供默认的实现
    // 所有的接口都默认继承它
    // 如果有必要 实现类可以进行重写
    // 访问 对象.方法名
    default void defaultMethod() {
        System.out.println("接口默认方法，默认实现。。。。");
    }


    //允许在已有的接口中添加静态方法，接口的静态方法属于接口本身，不被继承
    //也需要提供静态方法的实现
    //访问：类名.方法名
    static void staticMethod() {
        System.out.println("接口静态方法，默认实现...");
    }
}
