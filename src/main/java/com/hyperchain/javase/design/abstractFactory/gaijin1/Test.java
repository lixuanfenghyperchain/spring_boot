/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Test
 * Author:   lixuanfeng
 * Date:     2019/3/27 上午10:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.design.abstractFactory.gaijin1;

import com.hyperchain.javase.design.abstractFactory.IDepartment;
import com.hyperchain.javase.design.abstractFactory.IUser;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/3/27
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) throws Exception {
        IUser user = DataAccess.createUser();
        user.GetUser(1);
        IDepartment department = DataAccess.createDepartment();
        department.getDepartment(1);

    }
}