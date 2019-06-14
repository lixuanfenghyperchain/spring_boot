///**
// * Copyright (C), 2016-2019, 趣链科技有限有限公司
// * FileName: TestClassLoader
// * Author:   lixuanfeng
// * Date:     2019/6/1 下午8:45
// * Description:
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.hyperchain.javase.classloader;
//
//import cn.hyperchain.sdk.rpc.HyperchainAPI;
//import sun.misc.Launcher;
//import sun.rmi.rmic.iiop.ClassPathLoader;
//import sun.tools.java.ClassPath;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈〉
// *
// * @author lixuanfeng
// * @create 2019/6/1
// * @since 1.0.0
// */
//public class TestClassLoader {
//
//    public static void main(String[] args) {
//        ClassLoader c1 = TestClassLoader.class.getClassLoader();
//
//        System.out.println(HyperchainAPI.class.getClassLoader());
////        Launcher
//
////        ==============sun.misc.Launcher$AppClassLoader@18b4aac2
////        ==============sun.misc.Launcher$ExtClassLoader@26a1ab54   扩展类加载器  ext 下的jar
//
//        // 同一时间只允许一个线程来加载
//        // 一个类只被加载一次，没有被加载的才会被加载
//        // 类的加载先交给父类加载器加载，父类加载器没有加载到在由子类加载器加载   父ClassLoader能加载绝不给予子ClassLoader加载
//
////      顶层类加载器  BootstrapClassLoader   核心类加载器  lib
//
//        //  双亲委派   安全机制
//
//
////        while (c != null) {
////            System.out.println("==============" + c);
////            c = c.getParent();
////        }
//
//        Person p = new Person("张三");
//        System.out.println(p.getClass().getClassLoader());
//
//
//        ClassLoader c = new ClassPathLoader(new ClassPath(""));
//        try {
//            Class<?> aClass = c.loadClass("com.hyperchain.javase.classloader.Person");
//            System.out.println(aClass.getClassLoader());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}
//
//
//class Person {
//    private String name;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Person(String name) {
//        this.name = name;
//    }
//}