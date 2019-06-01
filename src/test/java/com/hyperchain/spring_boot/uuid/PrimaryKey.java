/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: PrimaryKey
 * Author:   lixuanfeng
 * Date:     2019/5/8 上午10:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.uuid;

import java.util.UUID;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/5/8
 * @since 1.0.0
 */
public class PrimaryKey {
    public static String getOrderIdByUUId() {
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodev = UUID.randomUUID().toString().hashCode();
        System.out.println(UUID.randomUUID().toString());
        if (hashCodev < 0) {
            //有可能是负数
            hashCodev = -hashCodev;
        }
        //"%015d"的意思：0代表不足位数的补0，这样可以确保相同的位数，15是位数也就是要得到到的字符串长度是15，d代表数字。
        return machineId + String.format("%015d", hashCodev);
    }


    public static void main(String[] args) {
        String orderNo = getOrderIdByUUId();
        String orderNo2 = getOrderIdByUUId();
        String orderNo3 = getOrderIdByUUId();
        System.out.println(orderNo);
        System.out.println(orderNo2);
        System.out.println(orderNo3);
    }
}