/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: Address
 * Author:   lixuanfeng
 * Date:     2018/8/7 下午3:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/8/7
 * @since 1.0.0
 */
@Entity
@Table(name = "tb_address")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
    @Id
    @GeneratedValue(generator = "id_uuid")
    @GenericGenerator(name = "id_uuid", strategy = "uuid")
    private String addressId;
    private String areaCode;
    private String country;
    private String province;
    private String city;
    private String area;
    private String detailAddress;

    @Override
    public String toString() {
        return "Address{" +
                "addressId='" + addressId + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                '}';
    }
}