/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: HelloController
 * Author:   lixuanfeng
 * Date:     2019/6/11 下午5:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.controller;

import com.hyperchain.vo.Order;
import com.hyperchain.vo.PropertyVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/11
 * @since 1.0.0
 */
//@Controller和@ResponseBody 结合体
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private PropertyVo propertyVo;


    /**
     * http://127.0.0.1:8080/hello/getHello   访问即可
     *
     * @return
     */
    @RequestMapping(value = "/getHello")
    public String Hello() {
        return "Hello world";
    }


    /**
     * rest风格
     *
     * @return
     */
    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
    public Order findOrder(@PathVariable("orderId") String orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setName("李玄风1221");
        order.setOrderAddr("四川广安");
        order.setOrderDate("2019-06-11");
        //通过实体类获取配置文件的值
        logger.info("INFO 日志" + propertyVo.getName());
        //日志级别可以直接在配置文件中配置不同包的不同日志级别
        logger.error("DEBUG 日志" + propertyVo.getName());
        return order;
    }

}