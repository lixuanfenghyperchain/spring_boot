/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Operation
 * Author:   lixuanfeng
 * Date:     2019/3/26 下午5:10
 * Description: 运算类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.design.strategy;

import lombok.Data;

/**
 * 〈一句话功能简述〉<br>
 * 〈运算类〉
 *
 * @author lixuanfeng
 * @create 2019/3/26
 * @since 1.0.0
 */
@Data
public class Operation {

    private double _numberA = 0;
    private double _numberB = 0;


    public double getResult() {
        double result = 0;
        return result;
    }


}