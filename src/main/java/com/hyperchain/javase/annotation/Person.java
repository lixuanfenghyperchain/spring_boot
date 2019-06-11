/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Person
 * Author:   lixuanfeng
 * Date:     2019/6/3 下午5:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.annotation;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/3
 * @since 1.0.0
 */

@Table("ccb_person")
public class Person {

    @Field(field_name = "person_id", field_type = "int", field_length = 10, primary_key = true)
    private int id;

    @Field(field_name = "person_name", field_type = "varchar", field_length = 10)
    private String name;

    @Field(field_name = "person_address", field_type = "varchar", field_length = 10)
    private String address;

    @Field(field_name = "person_age", field_type = "int", field_length = 2)
    private int age;

}