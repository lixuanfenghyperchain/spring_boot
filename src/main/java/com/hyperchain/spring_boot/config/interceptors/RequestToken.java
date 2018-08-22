/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: RequestToken
 * Author:   lixuanfeng
 * Date:     2018/7/25 下午7:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.config.interceptors;

import java.lang.annotation.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/7/25
 * @since 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@Documented
@Inherited
public @interface RequestToken {

}