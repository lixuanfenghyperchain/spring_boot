/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: UserInfo
 * Author:   lixuanfeng
 * Date:     2018/8/7 下午3:25
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
@Table(name = "tb_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(generator = "id_uuid")
    @GenericGenerator(name = "id_uuid", strategy = "uuid")
    private String userId;
    private String name;
    private int age;
    private String sex;
    private String email;

    // 与 Address 的关联
    private String addressId;


    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", addressId='" + addressId + '\'' +
                '}';
    }
}