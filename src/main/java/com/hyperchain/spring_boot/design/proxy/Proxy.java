/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Proxy
 * Author:   lixuanfeng
 * Date:     2019/3/27 下午3:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.design.proxy;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/3/27
 * @since 1.0.0
 */
public class Proxy implements GiveGift {


    Pursuit gg;

    public Proxy(SchoolGirl mm) {
        gg = new Pursuit(mm);
    }

    @Override
    public void giveDools() {
        gg.giveDools();
    }

    @Override
    public void giveFlowers() {
        gg.giveFlowers();
    }

    @Override
    public void giveChocolate() {
        gg.giveChocolate();
    }
}