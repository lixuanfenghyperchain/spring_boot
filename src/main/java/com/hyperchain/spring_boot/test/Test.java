/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: Test
 * Author:   lixuanfeng
 * Date:     2018/10/23 下午8:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.test;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/10/23
 * @since 1.0.0
 */

/**
 * 1  加载  jvm加载class字节码到方法区
 * <p>
 * 2  验证  jvm规范校验  代码逻辑校验
 * <p>
 * 3  准备  为类变量分配内存并初始化    包括初始化对象 初始化值
 * <p>
 * 4  解析
 * <p>
 * 5  初始化   类初始化  对象初始化
 * <p>
 * 6  使用
 * <p>
 * 7  卸载
 */

//执行顺序：（优先级从高到低）静态代码块>mian方法>构造代码块>构造方法
public class Test {

    public static final int a = 1;
    public static final String str = "aaa";




    static {
        System.out.println("静态代码块");
        System.out.println(str);
    }

    public Test() {
        System.out.println("构造函数");
        this.name = "aa";
    }


    public static void main(String[] args) {
//        new Test();
//        System.out.println("main 函数");
        new Test();
//        System.out.println(Test.str);
    }

    private String name;
    {
        System.out.println("普通代码块");
        System.out.println(name);
    }


}