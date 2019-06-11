/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: TestPerson
 * Author:   lixuanfeng
 * Date:     2019/6/3 下午5:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.annotation;

import java.lang.reflect.Field;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/3
 * @since 1.0.0
 */
public class TestPerson {


    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.hyperchain.javase.annotation.Person");
        //获取表名
        Table annotationTable = aClass.getAnnotation(Table.class);
        System.out.println(annotationTable.value());
        StringBuffer sb = new StringBuffer(200);
        sb.append("CREATE TABLE " + annotationTable.value() + "(");
        //获取所有字段
        Field[] fields = aClass.getDeclaredFields();
        String primary_key_field_name = null;
        for (int i = 0; i < fields.length; i++) {
            com.hyperchain.javase.annotation.Field annotation = fields[i].getAnnotation(com.hyperchain.javase.annotation.Field.class);
            String field_name = annotation.field_name();
            String field_type = annotation.field_type();
            int field_length = annotation.field_length();
            boolean b = annotation.primary_key();
            if (b) {
                primary_key_field_name = field_name;
            }
            sb.append(field_name + " " + field_type + "(" + field_length + "),");
        }
        if (null != primary_key_field_name) {
            sb.append("PRIMARY KEY (`" + primary_key_field_name + "`)");
        }
        sb.append(")");
        /**
         * CREATE TABLE `hyper_emails` (
         *   `id` int(11) NOT NULL AUTO_INCREMENT,
         *   `user_id` int(11) DEFAULT NULL,
         *   `email` varchar(100) DEFAULT NULL,
         *   `subscribed` tinyint(1) DEFAULT NULL,
         *   PRIMARY KEY (`id`),
         *   UNIQUE KEY `uix_hyper_emails_email` (`email`)
         * ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
         */

        /**
         * 优化思路: 把（）中的语句分一条一条放到list集合中
         */


        System.out.println(sb.toString());
    }

}