/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: BookController
 * Author:   lixuanfeng
 * Date:     2018/7/15 下午9:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.controller;

import com.hyperchain.spring_boot.dao.BookDao;
import com.hyperchain.spring_boot.entitiy.Book;
import com.hyperchain.spring_boot.vo.BaseResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/7/15
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/book")
@Api
public class BookController {
    @Autowired
    private BookDao bookDao;

    @RequestMapping("/getAllBooks")
    public BaseResult getAllBooks() {
        List<Book> allBook = bookDao.findAll();
        BaseResult baseResult = new BaseResult();
        baseResult.setData(allBook);
        return baseResult;
    }

}