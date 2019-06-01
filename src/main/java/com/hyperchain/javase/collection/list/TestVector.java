/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: TestVector
 * Author:   lixuanfeng
 * Date:     2019/6/1 下午7:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/1
 * @since 1.0.0
 */
public class TestVector {


    public static void main(String[] args) {
        List<Integer> squares = new Vector<>();
        for (int i = 0; i < 16; i++) {
            squares.add(i);
        }
    }
}