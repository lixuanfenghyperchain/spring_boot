/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: BookRepositoryTests
 * Author:   lixuanfeng
 * Date:     2018/8/7 下午4:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot;

import com.hyperchain.spring_boot.dao.AuthorRepository;
import com.hyperchain.spring_boot.dao.BookAuthorRepository;
import com.hyperchain.spring_boot.dao.BookRepository;
import com.hyperchain.spring_boot.entitiy.Author;
import com.hyperchain.spring_boot.entitiy.Book;
import com.hyperchain.spring_boot.entitiy.BookAuthor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/8/7
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTests {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookAuthorRepository bookAuthorRepository;

    @Test
    public void init() {
        Author lewis = new Author(null, "Lewis");
        Author mark = new Author(null, "Mark");
        Author peter = new Author(null, "Peter");
        authorRepository.save(lewis);
        authorRepository.save(mark);
        authorRepository.save(peter);

        Book spring = new Book(null, "Spring in Action");
        Book springboot = new Book(null, "Spring Boot in Action");
        bookRepository.save(spring);
        bookRepository.save(springboot);

        bookAuthorRepository.save(new BookAuthor(spring.getId(), lewis.getId()));
        bookAuthorRepository.save(new BookAuthor(spring.getId(), mark.getId()));
        bookAuthorRepository.save(new BookAuthor(springboot.getId(), mark.getId()));
        bookAuthorRepository.save(new BookAuthor(springboot.getId(), peter.getId()));
    }

//    @After
//    public void deleteAll() {
//        bookAuthorRepository.deleteAll();
//        bookRepository.deleteAll();
//        authorRepository.deleteAll();
//    }

    @Test
    public void findAll() {
        assertEquals(bookRepository.findAll().size(), 2);
        assertEquals(authorRepository.findAll().size(), 3);

        List<Map> books = bookRepository.findByNameContaining("Spring%");
        for (Map book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void findPageAuthor() {
        List<Map> pageBook = bookRepository.findPageBook();
        for (Object object : pageBook) {
            System.out.println(object);
        }
    }
}