/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: CommonManager
 * Author:   lixuanfeng
 * Date:     2019/3/28 上午10:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.design.chain;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/3/28
 * @since 1.0.0
 */
public class CommonManager extends Manager {


    public CommonManager(String name) {
        super(name);
    }

    @Override
    public void requestApplications(Request request) {
        if (request.getRequestType() == "请假" && request.getNumber() <= 2) {
            System.out.println(name + request.getRequestContent() + "数量" + request.getNumber() + "被批转");
        } else {
            if (superior != null) {
                superior.requestApplications(request);
            }
        }
    }
}