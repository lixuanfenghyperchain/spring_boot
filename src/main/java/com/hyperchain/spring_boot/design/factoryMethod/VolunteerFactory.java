/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: VolunteerFactory
 * Author:   lixuanfeng
 * Date:     2019/3/27 上午10:03
 * Description: 自愿者工厂
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.design.factoryMethod;

/**
 * 〈一句话功能简述〉<br>
 * 〈自愿者工厂〉
 *
 * @author lixuanfeng
 * @create 2019/3/27
 * @since 1.0.0
 */
public class VolunteerFactory implements IFactory {

    @Override
    public LeiFeng createLeiFeng() {
        return new Volunteer();
    }
}