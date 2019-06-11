/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Test
 * Author:   lixuanfeng
 * Date:     2019/6/2 下午1:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.java8.lamada.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/2
 * @since 1.0.0
 */
public class Test {

    static List<Employee> list = new ArrayList<>();


    public static void main(String[] args) {
        list.add(new Employee("张三", "23", 2221));
        list.add(new Employee("张2", "24", 6000));
        list.add(new Employee("张3", "25", 2000));
        list.add(new Employee("张4", "22", 5000));
        list.add(new Employee("张5", "27", 1000));


//        filterEmployeeSalary(list).forEach(System.out::println);

//        filterEmployCom(list, new FilterEmployAgeImpl()).forEach(System.out::println);
        //改进方式1 使用策略
//        filterEmployCom(list, new FilterEmploySalaryImpl()).forEach(System.out::println);
        //改进方式1 使用lambda表达式
        filterEmployCom(list, (e) -> e.getSalary() > 2000).forEach(System.out::println);
        list.stream()
                .filter((e) -> e.getSalary() > 3000)
                .map(Employee::getSalary)
                .forEach(System.out::println);

//        Comparator<Employee> com = new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getSalary() > o2.getSalary() ? -1 : 1;
//            }
//        };
//
//        Comparator<Employee> com2 = (o1, o2) -> o1.getSalary() > o2.getSalary() ? -1 : 1;
////        Collections.sort(list, com2);
//
//        Collections.sort(list,(o1,o2)->o1.getSalary() > o2.getSalary() ? -1 : 1);
//        list.forEach(System.out::println);

    }


    public static List<Employee> filterEmployeeSalary(List<Employee> employees) {
        List<Employee> emp = new ArrayList<>(10);
        for (Employee e : employees) {
            if (e.getSalary() > 3000) {
                emp.add(e);
            }
        }
        return emp;
    }

    public static List<Employee> filterEmployeeAge(List<Employee> employees) {
        List<Employee> emp = new ArrayList<>(10);
        for (Employee e : employees) {
            if (Integer.parseInt(e.getAge()) > 24) {
                emp.add(e);
            }
        }
        return emp;
    }


    //公共过滤方法  使用策略  要那种过滤方式就传入该接口的子类
    public static List<Employee> filterEmployCom(List<Employee> employees, FilterEmploy<Employee> filterEmploy) {
        List<Employee> emp = new ArrayList<>(10);
        for (Employee e : employees) {
            if (filterEmploy.filter(e)) {
                emp.add(e);
            }
        }
        return emp;
    }
}