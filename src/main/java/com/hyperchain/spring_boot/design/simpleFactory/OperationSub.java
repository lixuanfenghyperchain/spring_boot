/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: OperationSub
 * Author:   lixuanfeng
 * Date:     2019/3/26 下午5:15
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
public class OperationSub extends Operation {
    public double getResult() {
        return get_numberA() - get_numberB();
    }
}