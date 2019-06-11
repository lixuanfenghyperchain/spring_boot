/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: SqlserverUser
 * Author:   lixuanfeng
 * Date:     2019/3/27 上午10:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.design.abstractFactory;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/3/27
 * @since 1.0.0
 */

public class SqlserverUser implements IUser {

    public void Insert(User user) {
        System.out.println("在sqlserver中插入i 条数据");
    }

    @Override
    public User GetUser(int id) {
        System.out.println("在sqlserver中获取1 条数据");
        return null;
    }


}
