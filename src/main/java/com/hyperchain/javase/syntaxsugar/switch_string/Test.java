/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Test
 * Author:   lixuanfeng
 * Date:     2019/6/10 上午11:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.syntaxsugar.switch_string;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/10
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        String s = "H";
//原来字符串的switch是通过equals()和hashCode()方法来实现的.
// 进行switch的实际是哈希值，然后通过使用equals方法比较进行安全检查，这个检查是必要的，因为哈希可能会发生碰撞。
// 因此它的性能是不如使用枚举进行switch或者使用纯整数常量，但这也不是很差。

        switch (s) {
            case "he":
                System.out.println("he");
                break;
            case "he2":
                System.out.println("he2");
                break;
            case "H":
                System.out.println("H");
                break;
            default:
                System.out.println("error");
                break;
        }

    }
}