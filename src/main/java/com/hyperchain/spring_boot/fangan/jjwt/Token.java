/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Token
 * Author:   lixuanfeng
 * Date:     2019/6/14 上午10:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.fangan.jjwt;

import io.jsonwebtoken.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/14
 * @since 1.0.0
 */
public class Token {

    public static void main(String[] args) {
//        createToken();
        try {
            encodeToken();
        } catch (ExpiredJwtException e) {
            System.out.println("token expire");
        }
    }


    public static void createToken() {
        String secretKey = "123";
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("666")
                .setSubject("lxf")
                .setIssuedAt(new Date())//登录时间-也就是签发时间（签发给你token的时间）
                .setExpiration(new Date(new Date().getTime() + (60 * 1000)))//设置过期时间-一分钟
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())//设置签名秘钥

                /** token添加自定义属性 **/
                .claim("role", "admin");//设置用户角色

        System.out.println(jwtBuilder.compact());
    }


    public static void encodeToken() {
        String secretKey = "123";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLlsI_pqawiLCJpYXQiOjE1NjA0NzgyNTksImV4cCI6MTU2MDQ3ODMxOSwicm9sZSI6ImFkbWluIn0.thb5UT_AJDwvuPvZrcx1DLiLXzwYBTWH0gz8FzZULDg";

        Claims claims = Jwts.parser()
                .setSigningKey(secretKey.getBytes())//设置对应的盐
                .parseClaimsJws(token)
                .getBody();
        //Claims 这个claims你就可以认为它是一个map，里面是一个个key-value
        System.out.println("用户id：" + claims.getId());
        System.out.println("用户名称：" + claims.getSubject());
        System.out.println("登录时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));
        System.out.println("过期时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
        System.out.println("用户角色：" + claims.get("role"));
    }
}