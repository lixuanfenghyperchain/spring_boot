/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: ViewInfo
 * Author:   lixuanfeng
 * Date:     2018/8/7 下午3:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.entitiy;

import lombok.Data;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户和地址实体〉
 *
 * @author lixuanfeng
 * @create 2018/8/7
 * @since 1.0.0
 */
@Data
public class ViewInfo {
    private UserInfo userInfo;
    private Address address;

    public ViewInfo() {

    }

    public ViewInfo(UserInfo userInfo) {
        Address address = new Address();
        this.userInfo = userInfo;
        this.address = address;
    }

    public ViewInfo(Address address) {
        UserInfo userInfo = new UserInfo();
        this.userInfo = userInfo;
        this.address = address;
    }

    public ViewInfo(UserInfo userInfo, Address address) {
        this.userInfo = userInfo;
        this.address = address;
    }

}