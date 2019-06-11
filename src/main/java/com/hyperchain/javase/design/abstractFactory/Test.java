/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Test
 * Author:   lixuanfeng
 * Date:     2019/3/27 上午10:18
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
public class Test {


    public static void main(String[] args) {
        User user = new User();
        IFactory factory = new MysqlFactory();
        IUser iUser = factory.createUser();
        iUser.GetUser(1);
        iUser.Insert(user);


        Department department = new Department();


        IDepartment iDepartment = factory.createDepartment();
        iDepartment.createDepartment(department);
        iDepartment.getDepartment(1);
    }
}