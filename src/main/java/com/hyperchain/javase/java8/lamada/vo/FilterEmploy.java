package com.hyperchain.javase.java8.lamada.vo;

@FunctionalInterface
public interface FilterEmploy<T> {
    boolean filter(T t);
}
