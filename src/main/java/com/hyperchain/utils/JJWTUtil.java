/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: JJWTUtil
 * Author:   lixuanfeng
 * Date:     2019/6/14 下午2:35
 * Description: 加解密token工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.utils;

import com.hyperchain.vo.Token;
import com.hyperchain.vo.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈加解密token工具类〉
 *
 * @author lixuanfeng
 * @create 2019/6/14
 * @since 1.0.0
 */
public class JJWTUtil {

    private JJWTUtil() {
    }

    /**
     * 生成toekn字符串
     *
     * @param userId   用户id
     * @param userName 用户名
     * @param role     角色
     * @return
     */
    public static String createToken(String userId, String userName, String role) {
        String secretKey = "123";
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(userId)
                .setSubject(userName)
                .setIssuedAt(new Date())//登录时间-也就是签发时间（签发给你token的时间）
                .setExpiration(new Date(new Date().getTime() + (60 * 10000)))//设置过期时间6分钟
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())//设置签名秘钥
                /** token添加自定义属性 **/
                .claim("role", role);//设置用户角色
        return jwtBuilder.compact();
    }


    /**
     * 解密token
     *
     * @param tokenStr token字符串
     * @return
     */
    public static Token encodeToken(String tokenStr) {
        String secretKey = "123";
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey.getBytes())//设置对应的盐
                .parseClaimsJws(tokenStr)
                .getBody();
        //Claims 这个claims你就可以认为它是一个map，里面是一个个key-value
        String userId = claims.getId();
        String userName = claims.getSubject();
        String loginTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt());
        String expirationTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration());
        String role = (String) claims.get("role");
        Token token = new Token(userId, userName, 11111L, 11111L, role);
        return token;
    }
}