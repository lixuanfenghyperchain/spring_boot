/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: UserInfo
 * Author:   lixuanfeng
 * Date:     2019/6/21 下午2:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.vo.shiro;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/21
 * @since 1.0.0
 */
@Data
@Entity
public class UserInfo {
    @Id
//主键自动递增
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  roleName;
    private String  roleDes;
    private Boolean  available=Boolean.FALSE;

}