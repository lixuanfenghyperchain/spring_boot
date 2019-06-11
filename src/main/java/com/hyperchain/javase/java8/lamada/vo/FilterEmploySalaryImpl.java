/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: FilterEmployAgeImpl
 * Author:   lixuanfeng
 * Date:     2019/6/2 下午2:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.java8.lamada.vo;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/2
 * @since 1.0.0
 */
public class FilterEmploySalaryImpl implements FilterEmploy<Employee> {

    @Override
    public boolean filter(Employee employee) {
        return employee.getSalary() > 3000;
    }
}