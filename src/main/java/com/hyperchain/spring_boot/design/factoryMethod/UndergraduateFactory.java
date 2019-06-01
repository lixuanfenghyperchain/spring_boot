/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: UndergraduateFactory
 * Author:   lixuanfeng
 * Date:     2019/3/27 上午10:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.design.factoryMethod;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 * 学雷锋的大学生工厂
 *
 * @author lixuanfeng
 * @create 2019/3/27
 * @since 1.0.0
 */
public class UndergraduateFactory implements IFactory {

    @Override
    public LeiFeng createLeiFeng() {
        return new Undergraduate();
    }
}