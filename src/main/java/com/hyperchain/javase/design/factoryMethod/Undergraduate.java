/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Undergraduate
 * Author:   lixuanfeng
 * Date:     2019/3/27 上午9:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.design.factoryMethod;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 * 学雷锋大学生
 *
 * @author lixuanfeng
 * @create 2019/3/27
 * @since 1.0.0
 */
public class Undergraduate implements LeiFeng {

    @Override
    public void sweep() {
        System.out.println("大学生扫地");
    }

    @Override
    public void wash() {
        System.out.println("大学生洗衣服");
    }

    @Override
    public void buyRice() {
        System.out.println("大学生买米");
    }
}