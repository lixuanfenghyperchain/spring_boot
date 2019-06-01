/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: OperationAdd
 * Author:   lixuanfeng
 * Date:     2019/3/26 下午5:13
 * Description: 加法类 集成操作类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.design.strategy;

/**
 * 〈一句话功能简述〉<br>
 * 〈加法类 集成操作类〉
 *
 * @author lixuanfeng
 * @create 2019/3/26
 * @since 1.0.0
 */
public class OperationAdd extends Operation {
    public double getResult() {
        return get_numberA() + get_numberB();
    }
}