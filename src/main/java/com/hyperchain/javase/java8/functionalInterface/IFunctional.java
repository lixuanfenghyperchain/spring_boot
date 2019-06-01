package com.hyperchain.javase.java8.functionalInterface;

//函数是接口
@FunctionalInterface
public interface IFunctional<T, R> {


    //函数是接口 只能有一个抽象方法
    R handle(T t);

//    R handle2(T t);



}
