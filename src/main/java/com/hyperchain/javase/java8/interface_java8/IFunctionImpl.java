/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: IFunctionImpl
 * Author:   lixuanfeng
 * Date:     2019/6/1 上午10:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.java8.interface_java8;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/1
 * @since 1.0.0
 */
public class IFunctionImpl implements IFunctional {

    @Override
    public void method(String from) {
        System.out.println("子类实现了接口的抽象方法");
    }


    @Override
    public void defaultMethod() {
        System.out.println("子类重写接口的默认方法");
    }

    public static void main(String[] args) {
        IFunctionImpl iFunction = new IFunctionImpl();

        //访问接口的默认方法
        iFunction.defaultMethod();
        //访问接口的静态方法
        IFunctional.staticMethod();

    }
}