/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: JdbcTemplateTest
 * Author:   lixuanfeng
 * Date:     2018/8/9 上午9:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/8/9
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void findById() {
        String sql = "select * from author where id=?";
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, "2c90e5286513be21016513be3b870005");
        System.out.println(stringObjectMap);
    }

    @Test
    public void findAll() {
        String sql = "select * from author ";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println(maps);
    }

    @Test
    public void findObject() {
        String sql = "select id from author  where  id='2c90e5286513be21016513be3b870005'";
        String author = jdbcTemplate.queryForObject(sql, String.class);
        System.out.println(author);
    }

}