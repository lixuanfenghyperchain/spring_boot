/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: BookRepository
 * Author:   lixuanfeng
 * Date:     2018/8/7 下午4:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.dao;

import com.hyperchain.spring_boot.entitiy.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
public interface BookRepository extends JpaRepository<Book, String> {
    @Query(nativeQuery = true, value = "SELECT b.id, b.name, GROUP_CONCAT(a.name) as authorName from book b, author a, book_author ba"
            + " where b.id = ba.book_id and a.id = ba.author_id and b.name like ?1 group by b.id, b.name")
    List<Map> findByNameContaining(String name);

    @Query(nativeQuery = true, value = "select  * from  author limit 0,5")
    List<Map> findPageBook();

    @Query(nativeQuery = true, value = "select a.name as Name_name from author a where  id=?1")
    Map findBookById(String id);
}