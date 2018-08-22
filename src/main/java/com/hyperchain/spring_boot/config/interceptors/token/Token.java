/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: Token
 * Author:   lixuanfeng
 * Date:     2018/7/25 下午7:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.config.interceptors.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/7/25
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token {

    private String id;
    private String time;
    private String name;
    private String version;
}