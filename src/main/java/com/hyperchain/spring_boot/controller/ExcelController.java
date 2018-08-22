/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: ExcelController
 * Author:   lixuanfeng
 * Date:     2018/8/21 下午3:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.controller;

import com.hyperchain.spring_boot.component.excel.ExcelUtil;
import com.hyperchain.spring_boot.component.excel.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/8/21
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/excel")
public class ExcelController {
    @RequestMapping("/export")
    public void export(HttpServletResponse response) {

        //模拟从数据库获取需要导出的数据
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person("路飞", "1", "121212");
        Person person2 = new Person("娜美", "2", "12121");
        Person person3 = new Person("索隆", "1", "wqwq");
        Person person4 = new Person("小狸猫", "1", "ewew");
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        //导出操作
        ExcelUtil.exportExcel(personList, "花名册", "草帽一伙", Person.class, "海贼王.xls", response);
    }

    @RequestMapping("/importExcel")
    public void importExcel() {
        String filePath = "/Users/lixuanfeng/Desktop/海贼王.xls";
        //解析excel，
        List<Person> personList = ExcelUtil.importExcel(filePath, 1, 1, Person.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【" + personList.size() + "】行");

        //TODO 保存数据库
    }


}