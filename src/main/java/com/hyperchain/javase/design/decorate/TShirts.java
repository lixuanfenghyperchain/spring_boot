/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: TShirts
 * Author:   lixuanfeng
 * Date:     2019/3/27 下午3:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.design.decorate;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/3/27
 * @since 1.0.0
 */
public class TShirts extends Finery {


    @Override
    public void show() {
        System.out.println("大T恤");
        super.show();
    }
}