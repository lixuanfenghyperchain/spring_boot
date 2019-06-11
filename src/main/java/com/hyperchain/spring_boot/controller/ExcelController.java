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

import com.hyperchain.spring_boot.excel.Person;
import com.hyperchain.spring_boot.service.FileService;
import com.hyperchain.spring_boot.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
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

    @Value("${file.uploadUrl}")
    private String file_uploadUrl;

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/export", method = RequestMethod.GET)
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

    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public void importExcel(MultipartFile multipartFile, HttpServletRequest request) {

        String filePath = fileService.uploadFile(multipartFile, request);

        filePath = file_uploadUrl + File.separator + filePath;

        //这里的目录是写死的，所以需要先把文件上传至服务器再做excel导入功能。
//        String filePath = "/Users/lixuanfeng/Desktop/海贼王.xls";
        //解析excel，
        List<Person> personList = ExcelUtil.importExcel(filePath, 1, 1, Person.class);
        for (Person p : personList) {
            System.out.println(p.toString());
        }
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【" + personList.size() + "】行");

        //TODO 保存数据库
    }


}