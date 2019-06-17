/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: UserController
 * Author:   lixuanfeng
 * Date:     2019/6/14 下午2:28
 * Description: 用户控制器层
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.controller;

import com.hyperchain.base.response.BaseResult;
import com.hyperchain.base.response.ResultCode;
import com.hyperchain.cache.Guava;
import com.hyperchain.service.RedisService;
import com.hyperchain.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 〈一句话功能简述〉<br>
 * 〈用户控制器层〉
 *
 * @author lixuanfeng
 * @create 2019/6/14
 * @since 1.0.0
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private RedisService redisService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private Guava guava;

    @RequestMapping(value = "/login")
    public BaseResult login(String userName, String passWord) {
        if ("admin".equals(userName) && "123456".equals(passWord)) {
            //判断redis中数据是否存在
//            Object o = redisService.get("token:" + "001");
            Object o = guava.get("token:" + "001");
            if (false != (Boolean) o) {
                return BaseResult.fail(ResultCode.USER_ONLINE);
            }
            //默认设置一个id
            String userId = "001";
            //默认设置一个角色
            String role = "admin";
            //进行加密
            String token = tokenService.encodeToken(userId, userName, role);
            redisService.set("key:username", "{name:'lxf'}");
            //6分钟过期时间
            redisService.set("token:" + userId, token, 20);
            //该方法是覆盖偏移量的值
//            redisTemplate.opsForValue().set("token:" + userId, token, 20);
            //给前端返回token
            return BaseResult.success(ResultCode.SUCCESS, token);
        } else {
            return BaseResult.fail(ResultCode.USERNAME_OR_PASSWORD_ERROR);

        }
    }
}