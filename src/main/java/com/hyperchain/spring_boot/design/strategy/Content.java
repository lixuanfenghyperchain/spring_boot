/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Content
 * Author:   lixuanfeng
 * Date:     2019/3/26 下午5:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.design.strategy;


/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/3/26
 * @since 1.0.0
 */
public class Content {

    private Operation operation;

    public Content(String operate, double numberA, double numberB) {
        switch (operate) {
            case "+":
                this.operation = new OperationAdd();
                break;
            case "-":
                this.operation = new OperationSub();
                break;
            default:
                System.out.println("输入操作符有误！");
                break;
        }
        operation.set_numberA(numberA);
        operation.set_numberB(numberB);
    }


    public double getResult() {
        return operation.getResult();
    }

}