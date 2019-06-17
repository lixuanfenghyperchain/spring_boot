/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: JWTUtil
 * Author:   lixuanfeng
 * Date:     2019/6/14 下午5:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.utils;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hyperchain.vo.Token;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/14
 * @since 1.0.0
 */
@Slf4j
public class JWTUtil {
    private static final long EXPIRE_TIME = 60 * 1000 * 6;
    private static final String TOKEN_SECRET = "thefirsttoken123";


    public static String sign(Token token) {
        try {
            Long loginTime = System.currentTimeMillis();
            token.setLoginTime(loginTime);
            // 设置过期时间
            Date date = new Date(loginTime + EXPIRE_TIME);
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            // 返回token字符串
            return JWT.create()
                    .withHeader(header)
                    .withClaim("token", JSONUtil.objectToJSONString(token))
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            log.error("生成token失败", e);
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 检验token是否正确
     *
     * @param **token**
     * @return
     */
    public static Token verify(String tokenStr) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(tokenStr);
            Token token = JSONObject.parseObject(jwt.getClaim("token").asString(), Token.class);
            Long expirationTime = jwt.getExpiresAt().getTime();
            token.setExpirationTime(expirationTime);
            return token;
        } catch (Exception e) {
            log.error("验证token失败", e);
            return null;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Token token = new Token();
        token.setUserId("110");
        token.setUserName("lxf");
        token.setRole("admin");
        System.out.println(token);
        String sign = sign(token);
        System.out.println(sign);
        Token verify = verify(sign + "aa");
        System.out.println(verify);
    }

}