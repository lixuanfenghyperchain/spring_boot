/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: InnerSingleton
 * Author:   lixuanfeng
 * Date:     2018/10/16 下午2:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.design;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/10/16
 * @since 1.0.0
 */
public class InnerSingleton {

    private static class Singleton {

        private static InnerSingleton single = new InnerSingleton();

    }

    public static InnerSingleton getInstance() {
        return Singleton.single;
    }

    public static void main(String[] args) {
        InnerSingleton instance = InnerSingleton.getInstance();
        InnerSingleton instance1 = InnerSingleton.getInstance();
        System.out.println(instance.equals(instance1));
    }

}