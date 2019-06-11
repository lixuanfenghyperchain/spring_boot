/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: OperationFactory
 * Author:   lixuanfeng
 * Date:     2019/3/26 下午5:16
 * Description: 操作工厂类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.design.strategy;

/**
 * 〈一句话功能简述〉<br>
 * 〈操作工厂类〉
 *
 * @author lixuanfeng
 * @create 2019/3/26
 * @since 1.0.0
 */
public class OperationFactory {

    public static Operation createOperation(String operate) {
        Operation operation = null;
        switch (operate) {
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
            default:
                System.out.println("输入操作符有误！");
                break;
        }
        return operation;
    }

}