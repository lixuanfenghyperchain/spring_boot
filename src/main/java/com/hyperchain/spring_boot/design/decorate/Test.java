/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Test
 * Author:   lixuanfeng
 * Date:     2019/3/27 下午3:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.design.decorate;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/3/27
 * @since 1.0.0
 */
public class Test {


    public static void main(String[] args) {
        Person xc = new Person("李玄峰");
        System.out.println("第一钟装扮");

        TShirts tShirts = new TShirts();

        BigTrouser bigTrouser = new BigTrouser();

        XiZhuang xiZhuang = new XiZhuang();
        tShirts.Decorate(xc);

        bigTrouser.Decorate(tShirts);

        xiZhuang.Decorate(bigTrouser);

        xiZhuang.show();
    }
}