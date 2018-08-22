/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: UserAdd
 * Author:   lixuanfeng
 * Date:     2018/7/22 上午9:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/7/22
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAdd {
    @NotEmpty(message = "姓名不能为空")
    private String name;
    @Length(min = 6, message = "密码长度不能小于6位数！")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,20}$", message = "密码格式不对")
    private String password;
    @NotEmpty(message = "地址不能为空")
    private String addr;
    @Email(message = "邮箱格式不对")
    private String email;
    @Pattern(regexp = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$", message = "手机格式有误")
    //  @NotEmpty(message = "电话号码不能为空！")
    //   @Length(min = 11, max = 11, message = "手机号码长度必须为11位！")
    private String phone;

}