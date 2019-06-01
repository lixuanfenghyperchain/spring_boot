/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: UserMyAnnotation
 * Author:   lixuanfeng
 * Date:     2019/3/26 上午11:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.aop;

import com.hyperchain.spring_boot.aop.annotation.MyAnnotation;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/3/26
 * @since 1.0.0
 */
@MyAnnotation(values = "lll")
public class UserMyAnnotation {

    @MyAnnotation(values = "lxf")
    public void say() {
        System.out.println("hello ");
    }


}