/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Test
 * Author:   lixuanfeng
 * Date:     2019/3/26 下午5:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.design.simpleFactory;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/3/26
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {

        Operation operation = OperationFactory.createOperation("-");
        operation.set_numberA(10.4);
        operation.set_numberB(88.9);
        //多态
        System.out.println(operation.getResult());
    }

}