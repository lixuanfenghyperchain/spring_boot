/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Order
 * Author:   lixuanfeng
 * Date:     2019/6/11 下午5:39
 * Description: 订单实体
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.vo;


import java.util.Objects;

/**
 * 〈一句话功能简述〉<br>
 * 〈订单实体〉
 *
 * @author lixuanfeng
 * @create 2019/6/11
 * @since 1.0.0
 */
public class Order {

    private String orderId;
    private String orderDate;
    private String orderAddr;
    private String phone;
    private String name;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderAddr() {
        return orderAddr;
    }

    public void setOrderAddr(String orderAddr) {
        this.orderAddr = orderAddr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", orderAddr='" + orderAddr + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(getOrderId(), order.getOrderId()) &&
                Objects.equals(getOrderDate(), order.getOrderDate()) &&
                Objects.equals(getOrderAddr(), order.getOrderAddr()) &&
                Objects.equals(getPhone(), order.getPhone()) &&
                Objects.equals(getName(), order.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getOrderId(), getOrderDate(), getOrderAddr(), getPhone(), getName());
    }
}