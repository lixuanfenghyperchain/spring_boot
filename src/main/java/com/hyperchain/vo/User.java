/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: User
 * Author:   lixuanfeng
 * Date:     2019/6/14 上午11:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.vo;

import lombok.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/14
 * @since 1.0.0
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class User {

    private String userId;
    private String name;
    private String psw;
    private String role;

    public User(String name, String psw) {
        this.name = name;
        this.psw = psw;
    }
}