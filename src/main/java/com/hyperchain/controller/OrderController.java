/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: OrderController
 * Author:   lixuanfeng
 * Date:     2019/6/12 下午5:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.controller;

import com.hyperchain.base.WMap;
import com.hyperchain.base.exception.BusinessException;
import com.hyperchain.base.response.BaseResponse;
import com.hyperchain.base.response.ResponseCode;
import com.hyperchain.dao.GirlDao;
import com.hyperchain.dao.GirlRepository;
import com.hyperchain.vo.Girl;
import com.hyperchain.vo.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/12
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlDao girlDao;

    @RequestMapping("/girl/{girlId}")
    public Girl findGirl(@PathVariable("girlId") Integer girlId) {

        return girlRepository.findById(girlId).get();
    }

    @RequestMapping("/girls")
    public List<WMap> findGirls() {
        int pageNumber = 1;
        int pageSize = 5;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        List<WMap> girls = girlRepository.findGirlById(22);
        System.out.println(111);
        return girls;
    }

    @RequestMapping("/findGirlById")
    public BaseResponse findGirlById() {
//        return girlDao.findGirlById("44");
        return BaseResponse.success(ResponseCode.SUCCESS, new Order());
    }


    @RequestMapping("/findOrders")
    public BaseResponse findOrders() {
        List<Order> orderList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setOrderId(String.valueOf(i));
            order.setName("李玄风");
            order.setAddress("四川广安");
            orderList.add(order);
        }
        return BaseResponse.success(ResponseCode.SUCCESS, orderList);
    }


    @RequestMapping("/exception")
    public BaseResponse exception() {
        if (1 == 1) {
            throw new BusinessException(ResponseCode.USER_NOT_EXIT);
        }
        return BaseResponse.success(ResponseCode.SUCCESS, "你好");
    }
}