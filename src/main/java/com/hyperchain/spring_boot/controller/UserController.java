/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: UserController
 * Author:   lixuanfeng
 * Date:     2018/7/22 上午9:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.controller;

import com.hyperchain.spring_boot.config.interceptors.MyTokenArgumentResolver;
import com.hyperchain.spring_boot.model.UserAdd;
import com.hyperchain.spring_boot.vo.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/7/22
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/user")
@Slf4j

@Validated
public class UserController {
    @Autowired
    private MyTokenArgumentResolver myTokenArgumentResolver;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public BaseResult addUser(@RequestBody @Valid UserAdd userAdd, @NotEmpty(message = "姓名不能为空") String name) {
        BaseResult baseResult = new BaseResult();
//        if (result.hasErrors()) {
//            List<FieldError> fieldErrors = result.getFieldErrors();
//            Map<String, String> errMap = new LinkedHashMap<String, String>();
//            for (FieldError fieldError : fieldErrors) {
//                errMap.put(fieldError.getField(), fieldError.getDefaultMessage());
//            }
//            baseResult.setData(errMap);
//            baseResult.setCode(Code.RETURN_FALSE.getCode());
//            baseResult.setMessage("格式校验有误！");
//
//        } else {
//            baseResult.setData("添加用户成功！");
//            baseResult.setCode(Code.RETURN_SUCCESS.getCode());
//            baseResult.setMessage("添加用户成功！");
//        }
        return baseResult;
    }

    @RequestMapping(value = "/valid", method = RequestMethod.POST)
    @Valid
    public BaseResult valid(@RequestParam @NotEmpty(message = "姓名不能为空") String name,
                            @RequestParam @Email(message = "邮箱格式有误") String email) {
        BaseResult baseResult = new BaseResult();

        return baseResult;
    }

//    @RequestMapping(value = "/user")
//    @Valid
//    public BaseResult user(String confirm_passWord, String new_passWord, String old_passWord, HttpServletResponse response) {
//        // 允许跨域访问的域名：若有端口需写全（协议+域名+端口），若没有端口末尾不用加'/'
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        System.out.println(confirm_passWord);
//        System.out.println(old_passWord);
//        System.out.println(new_passWord);
//        BaseResult baseResult = new BaseResult();
//        baseResult.setMessage("ok");
//        baseResult.setCode(1);
//        return baseResult;
//    }

    @RequestMapping(value = "/user")
    @Valid
    public BaseResult userPost(HttpServletRequest request, HttpServletResponse response, String confirm_passWord, String new_passWord, String old_passWord) {
        // 允许跨域访问的域名：若有端口需写全（协议+域名+端口），若没有端口末尾不用加'/'
        response.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println(request.getParameter("confirm_passWord"));
        System.out.println(request.getParameter("old_passWord"));
        System.out.println(request.getParameter("new_passWord"));
        System.out.println("=======================直接封装=====================");
        System.out.println(confirm_passWord);
        System.out.println(old_passWord);
        System.out.println(new_passWord);
        BaseResult baseResult = new BaseResult();
        baseResult.setMessage("ok");
        baseResult.setCode(1);
        return baseResult;
    }
}