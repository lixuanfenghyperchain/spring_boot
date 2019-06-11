/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: HeapOutOfMemory
 * Author:   lixuanfeng
 * Date:     2018/11/12 下午8:51
 * Description: 堆溢出代码
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈堆溢出代码〉
 *
 * @author lixuanfeng
 * @create 2018/11/12
 * @since 1.0.0
 */

//java.lang.OutOfMemoryError: Java heap space
public class HeapOutOfMemory {

    public static void main(String[] args) {
        List list = new ArrayList();
        while (true) {
            list.add(new HeapOutOfMemory());
        }
    }

}