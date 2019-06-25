/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Test
 * Author:   lixuanfeng
 * Date:     2019/6/19 下午8:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.io.serializable;

import java.io.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/19
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Person person = new Person();
//        person.setAddr("xxx");
//        person.setAge(12);
//        person.setName("lxf");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("/Users/lixuanfeng/Desktop/workspace/spring_boot/Person.txt")));
//        objectOutputStream.writeObject(person);


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("/Users/lixuanfeng/Desktop/workspace/spring_boot/Person.txt")));
        Person person = (Person) ois.readObject();
        System.out.println(person.getAddr());
        System.out.println("Person对象反序列化成功！");
    }

}