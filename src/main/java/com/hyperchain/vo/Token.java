/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Token
 * Author:   lixuanfeng
 * Date:     2019/6/14 下午3:07
 * Description: token实体
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.vo;

import lombok.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈token实体〉
 *
 * @author lixuanfeng
 * @create 2019/6/14
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Token {
    private String userId;
    private String userName;
    private Long loginTime;
    private Long expirationTime;
    private String role;
}