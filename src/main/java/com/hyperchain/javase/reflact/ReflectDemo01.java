package com.hyperchain.javase.reflact;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 */
public class ReflectDemo01 {
    //通过反射获取类
    public static void demo01() {
        //获取反射对象（反射入口）：Class ，1 Class.forName(全类名)   2 类名.class  3 对象.getClass()
        //1 Class.forName("全类名")
        try {
            Class<?> perClazz = Class.forName("com.hyperchain.javase.reflact.Person");
            System.out.println(perClazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//		 2 类名.class
        Class<?> perClazz2 = Person.class;
        System.out.println(perClazz2);

//		 3 对象.getClass()
        Person per = new Person();
        Class<?> perClazz3 = per.getClass();
        System.out.println(perClazz3);
    }

    //获取公共方法
    public static void demo02() {
        //Class入口
        Class<?> perClazz = null;
        try {
            perClazz = Class.forName("com.hyperchain.javase.reflact.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //获取所有的 公共的方法(1.本类 以及 父类、接口中的所有方法  2.符合访问修饰符规律)
        Method[] methods = perClazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("==========");
        //获取当前类的所有方法（1.只能是当前类   2.忽略访问修饰符限制）
        Method[] declaredMethods = perClazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }

    //获取所有的接口
    public static void demo03() {
        Class<?> perClazz = null;
        try {
            perClazz = Class.forName("com.hyperchain.javase.reflact.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class<?>[] interfaces = perClazz.getInterfaces();
        for (Class<?> inter : interfaces) {
            System.out.println(inter);
        }
    }

    //获取所有的父类
    public static void demo04() {
        Class<?> perClazz = null;
        try {
            perClazz = Class.forName("com.hyperchain.javase.reflact.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class<?> superclass = perClazz.getSuperclass();
        System.out.println(superclass);

    }


    //获取所有的构造方法
    public static void demo05() {
        Class<?> perClazz = null;
        try {
            perClazz = Class.forName("com.hyperchain.javase.reflact.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor<?>[] constructors = perClazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);

        }
    }

    //获取所有的公共属性
    public static void demo06() {
        Class<?> perClazz = null;
        try {
            perClazz = Class.forName("com.hyperchain.javase.reflact.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //公共属性
        Field[] fields = perClazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("====");
        //所有属性  (属性的 ：公共属性\所有属性的区别 同“方法”)
        Field[] declaredFields = perClazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
    }

    //获取当前反射所代表类（接口） 的对象（实例）
    public static void demo07() throws InstantiationException, IllegalAccessException {
        Class<?> perClazz = null;
        try {
            perClazz = Class.forName("com.hyperchain.javase.reflact.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Object instance = perClazz.newInstance();
        Person per = (Person) instance;
        per.interface2Method();
    }


    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//		demo01();
//		demo02(); //所有公共方法，本类的所有方法
//		demo03();//所有接口
//		demo04();  // 所有父类
//      demo05(); // 所有构造方法
//		demo06();
//		demo07();
    }

}