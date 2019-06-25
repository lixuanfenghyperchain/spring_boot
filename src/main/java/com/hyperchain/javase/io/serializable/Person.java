/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Person
 * Author:   lixuanfeng
 * Date:     2019/6/19 下午8:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.io.serializable;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/19
 * @since 1.0.0
 */
@Data
public class Person implements Serializable {
    private String name;
    private String addr;
    private int age;

}

