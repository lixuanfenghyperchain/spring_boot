/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: MonitorUtil
 * Author:   lixuanfeng
 * Date:     2019/6/3 下午3:18
 * Description: 时间监控工具
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.utils;

/**
 * 〈一句话功能简述〉<br>
 * 〈时间监控工具〉
 *
 * @author lixuanfeng
 * @create 2019/6/3
 * @since 1.0.0
 */
public class MonitorUtil {
    private static ThreadLocal<Long> tl = new ThreadLocal<>();

    public static void start() {
        tl.set(System.currentTimeMillis());
    }

    //结束时打印耗时
    public static void finish(String methodName) {
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName + "方法耗时" + (finishTime - tl.get()) + "ms");
    }
}