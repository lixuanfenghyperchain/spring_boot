/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: BaseDaoTest
 * Author:   lixuanfeng
 * Date:     2018/8/8 上午10:36
 * Description: 持久层基础类测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.dao;

import com.hyperchain.spring_boot.base.dao.impl.BaseDao;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 〈一句话功能简述〉<br>
 * 〈持久层基础类测试〉
 *
 * @author lixuanfeng
 * @create 2018/8/8
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseDaoTest {

    @Autowired
    private BaseDao baseDao;

//    @Test
//    public void selectById() {
//        String sql = "select * from author where id=?";
//        List<Object> list = new ArrayList<Object>();
//        list.add("2c90e5286513be21016513be3b870002");
//        Map map = baseDao.getMap(sql, list);
//        System.out.println(map);
//    }

//    @Test
//    public void getPage() {
//        String sql = "select * from author where name=? order by id  ";
//        Page page = new Page();
//        page.setPage(0);
//        page.setPageSize(5);
//        List<Object> list = new ArrayList<Object>();
//        list.add("lxf");
//        page = baseDao.getPage(sql, page, list);
//        System.out.println(page);
//
//    }
}