/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: TokenService
 * Author:   lixuanfeng
 * Date:     2019/6/14 下午8:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.service;

import com.hyperchain.utils.JWTUtil;
import com.hyperchain.vo.Token;
import com.hyperchain.vo.User;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/14
 * @since 1.0.0
 */
@Service
public class TokenService {

    public String encodeToken(User user) {
        return JWTUtil.sign(Token.builder().userId(user.getUserId()).userName(user.getName()).role(user.getRole()).build());
    }


    public String encodeToken(String userID, String userName, String role) {
        return JWTUtil.sign(Token.builder().userId(userID).userName(userName).role(role).build());
    }

    public Token decodeToken(String token) {
        return JWTUtil.verify(token);
    }
}