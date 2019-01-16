/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: TestJsonUtil
 * Author:   lixuanfeng
 * Date:     2018/8/22 下午2:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.utils;

import com.hyperchain.spring_boot.model.UserAdd;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/8/22
 * @since 1.0.0
 */
public class TestJsonUtil {

    public static void main(String[] args) {


        List list = new ArrayList();

        UserAdd userAdd = new UserAdd();

        userAdd.setAddr("fdsaf");
        userAdd.setEmail("fdsa");
        userAdd.setPassword("fdsa");
        UserAdd userAdd1 = new UserAdd();

        userAdd1.setAddr("fdsaf");
        userAdd1.setEmail("fdsa");
        userAdd1.setPassword("fdsa");

        list.add(userAdd);
        list.add(userAdd1);
        System.out.println(JSONUtil.objectToJSONString(userAdd));

        System.out.println(JSONUtil.listToJSONString(list));
    }

}
