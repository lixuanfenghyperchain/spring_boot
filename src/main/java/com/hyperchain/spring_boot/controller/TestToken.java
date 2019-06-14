/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: TestToken
 * Author:   lixuanfeng
 * Date:     2018/7/25 下午7:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.controller;

import com.hyperchain.spring_boot.config.interceptors.RequestToken;
import com.hyperchain.spring_boot.config.interceptors.token.Token;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/7/25
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/token")
public class TestToken {
    @RequestMapping(value = "/testToken", method = RequestMethod.POST)
    public String testToken(@ApiIgnore @RequestToken Token token) {
        System.out.println("进入方法¬");
        if (StringUtils.isEmpty(token.getId())) {
            return "token is empty";
        }
        return "success";
    }
}