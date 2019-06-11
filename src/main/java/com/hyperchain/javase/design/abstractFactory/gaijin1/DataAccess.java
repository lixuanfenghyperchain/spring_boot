/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: DataAccess
 * Author:   lixuanfeng
 * Date:     2019/3/27 上午10:31
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
public class DataAccess {

    private static final String assemblyName = "com.hyperchain.spring_boot.design.abstractFactory";
    private static final String db = "Mysql";
//    private static final String db = "Sqlserver";


    public static IUser createUser() throws Exception {
        String className = assemblyName + "." + db + "User";
        IUser aClass = (IUser) Class.forName(className).newInstance();
        return aClass;

    }


    public static IDepartment createDepartment() throws Exception {
        String className = assemblyName + "." + db + "Department";
        IDepartment aClass = (IDepartment) Class.forName(className).newInstance();

        return aClass;

    }

}