/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: TestController
 * Author:   lixuanfeng
 * Date:     2018/7/15 下午4:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.controller;

import com.hyperchain.spring_boot.aop.annotation.Permission;
import com.hyperchain.spring_boot.aop.annotation.UserAccess;
import com.hyperchain.spring_boot.vo.BaseResult;
import com.hyperchain.spring_boot.vo.MyProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/7/15
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/spring_boot/test")
@Api
public class TestController {
    //获取配置文件属性值的方式
    // 第一种 注解形式
    @Value("${server.port}")
    private String server_port;
    //第二种 使用这种方式是依赖注入Evnironment来完成，
    // 在创建的成员变量private Environment env上加上@Autowired注解即可完成依赖注入，
    // 然后使用env.getProperty("键名")即可读取出对应的值。
    @Autowired
    private Environment environment;

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    @ApiOperation(value = "你好 spring_boot", notes = "你好 spring_boot")
    @UserAccess(desc = "hello_annotation")
    public String hello(
            @ApiParam(value = "输入参数", required = false) String string,
            @ApiParam(value = "name", required = false) String name,
            @ApiParam(value = "age", required = false) String age) {
        System.out.println("进入方法");
        return "hello spring_boot";
    }

    @RequestMapping(value = "/getServerPort", method = RequestMethod.POST)
    public String getConfig() {
        return server_port + "=============" + environment.getProperty("auth");

    }

    @RequestMapping(value = "/getBaseResult", method = RequestMethod.POST)
    public BaseResult getBaseResult() {
        BaseResult baseResult = new BaseResult();
        List<String> listString = new ArrayList<String>();
        listString.add("zhangsan");
        listString.add("lisi");
        listString.add("wangwu");
        baseResult.setCode(1);
        baseResult.setMessage("查询成功！");
        baseResult.setData(listString);
        return baseResult;

    }

    @RequestMapping(value = "/testAnnotation", method = RequestMethod.POST)
    @Permission(value = "22")
    public BaseResult testAnnotation(String name, String age) {
        System.out.println(name + age);
        BaseResult baseResult = new BaseResult();
        return baseResult;
    }





    //获取自定义配置文件的值
    @Autowired
    private MyProperty myProperty;

    @RequestMapping(value = "/getMyConfig", method = RequestMethod.POST)
    public String getMyConfig() {
        return myProperty.getAge() + "======" + myProperty.getName();
    }

}