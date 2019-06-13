/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Order
 * Author:   lixuanfeng
 * Date:     2019/6/12 下午6:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.vo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.Objects;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/12
 * @since 1.0.0
 */
@Configuration
public class Order implements Serializable {

    private String orderId;
    private String address;
    private String name;
    private String date;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(getOrderId(), order.getOrderId()) &&
                Objects.equals(getAddress(), order.getAddress()) &&
                Objects.equals(getName(), order.getName()) &&
                Objects.equals(getDate(), order.getDate());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getOrderId(), getAddress(), getName(), getDate());
    }

    @Bean
    public Order instanceBean() {
        return new Order();
    }

}