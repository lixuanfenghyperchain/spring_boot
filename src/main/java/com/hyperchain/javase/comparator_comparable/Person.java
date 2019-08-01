/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Person
 * Author:   lixuanfeng
 * Date:     2019/6/3 上午9:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.comparator_comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 * Comparable  内部比较器
 *
 * @author lixuanfeng
 * @create 2019/6/3
 * @since 1.0.0
 */
public class Person implements Comparable<Person> {

    private String name;
    private String address;
    private int age;
    private double salary;

    public Person(String name, String address, int age, double salary) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Person o) {
//        int result = age > o.getAge() ? 1 : (age == o.getAge() ? 0 : -1);
        //年龄相等 比较工资
        int result = Integer.compare(age, o.getAge());
        if (result == 0) {
            result = Double.compare(salary, o.getSalary());
        }
        return result;
    }


    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("xlf2", "sichuan", 55, 50000),
                new Person("xlf3", "sichuan", 55, 40000),
                new Person("xlf4", "sichuan", 15, 50000),
                new Person("xlf", "sichuan", 25, 10000),
                new Person("xlf1", "sichuan", 23, 20000)
        );
        //使用内部比较器
//        Collections.sort(personList);

        //使用内部外部比较器 使用lambda表达式

        Collections.sort(personList, (o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary()));

        // 使用Stream Api  进行内部排序，然后再转集合
//        List<Person> collect = personList.stream().sorted().collect(Collectors.toList());
        // 使用Stream Api  进行外部排序，然后转集合
//        List<Person> collect = personList.stream().sorted((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary())).collect(Collectors.toList());


    }
}