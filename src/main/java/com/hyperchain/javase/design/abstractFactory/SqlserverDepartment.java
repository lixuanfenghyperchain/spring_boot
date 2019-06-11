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

public class SqlserverDepartment implements IDepartment {


    @Override
    public void createDepartment(Department department) {
        System.out.println("在sqlserver中插入部门");
    }

    @Override
    public Department getDepartment(int i) {
        System.out.println("在sqlserver中获取部门");
        return null;
    }
}
