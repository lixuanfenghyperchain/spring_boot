package com.hyperchain.javase.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Field {
    //字段名称
    String field_name();

    //字段类型
    String field_type();

    //字段长度
    int field_length();

    boolean primary_key() default false;

//    String[]  hobby() default {"篮球"};
}
