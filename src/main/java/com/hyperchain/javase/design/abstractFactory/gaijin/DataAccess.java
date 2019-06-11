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
package com.hyperchain.javase.design.abstractFactory.gaijin;

import com.hyperchain.javase.design.abstractFactory.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/3/27
 * @since 1.0.0
 */
public class DataAccess {


//    private static final String db = "mysql";
    private static final String db = "sqlserver";


    public static IUser createUser() {
        IUser iUser = null;
        switch (db) {
            case "mysql":
                iUser = new MysqlUser();
                break;
            case "sqlserver":
                iUser = new SqlserverUser();
                break;
        }
        return iUser;
    }


    public static IDepartment createDepartemnt() {
        IDepartment department = null;
        switch (db) {
            case "mysql":
                department = new MysqlDepartment();
                break;
            case "sqlserver":
                department = new SqlserverDepartment();
                break;
        }
        return department;
    }

}