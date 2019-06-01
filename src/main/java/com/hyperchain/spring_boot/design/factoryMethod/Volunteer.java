/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Volunteer
 * Author:   lixuanfeng
 * Date:     2019/3/27 上午10:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.design.factoryMethod;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/3/27
 * @since 1.0.0
 */
public class Volunteer implements LeiFeng {

    @Override
    public void sweep() {
        System.out.println("自愿者扫地");
    }

    @Override
    public void wash() {
        System.out.println("自愿者洗衣服");
    }

    @Override
    public void buyRice() {
        System.out.println("自愿者买米");
    }
}