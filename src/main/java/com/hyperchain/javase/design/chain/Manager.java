/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Manager
 * Author:   lixuanfeng
 * Date:     2019/3/28 上午10:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.design.chain;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/3/28
 * @since 1.0.0
 */
public abstract class Manager {


    protected String name;

    protected Manager superior;

    public Manager(String name) {
        this.name = name;
    }


    public void setSuperior(Manager superior) {
        this.superior = superior;
    }

    public abstract void requestApplications(Request request);

}