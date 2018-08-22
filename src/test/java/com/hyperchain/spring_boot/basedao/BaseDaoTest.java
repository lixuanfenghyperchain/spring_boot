/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: BaseDaoTest
 * Author:   lixuanfeng
 * Date:     2018/8/9 上午11:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.basedao;

import com.hyperchain.spring_boot.base.WMap;
import com.hyperchain.spring_boot.base.dao.impl.BaseDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

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
public class BaseDaoTest {
    @Autowired
    private BaseDao baseDao;

    @Test
    public void getById() throws SQLException {
        WMap map = baseDao.getMap("select * from author where id='2c90e5286513be21016513be3b870005'");
        System.out.println(map);
    }
}