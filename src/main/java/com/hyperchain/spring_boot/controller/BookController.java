/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: BookController
 * Author:   lixuanfeng
 * Date:     2018/8/7 下午6:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.controller;

import com.hyperchain.spring_boot.dao.BookRepository;
import com.hyperchain.spring_boot.dao.mapper.BookMapper;
import com.hyperchain.spring_boot.entitiy.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/8/7
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;

    @RequestMapping(value = "/pageBook", method = RequestMethod.POST)
    List<Map> pageBook() {
        return bookRepository.findByNameContaining("Spring%");
    }

    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    Map findById() {
        Map bookById = bookRepository.findBookById("2c90e5286513be21016513be3b870002");
        System.out.println(bookById);
        return bookById;
    }

    @RequestMapping(value = "/getBookByName", method = RequestMethod.POST)
    Book findBookByName() {
        Book book = bookMapper.findBookrByName("Spring Boot in Action");
        return book;
    }

}