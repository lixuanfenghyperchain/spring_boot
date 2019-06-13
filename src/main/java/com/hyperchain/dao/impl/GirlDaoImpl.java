/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: GirlDao
 * Author:   lixuanfeng
 * Date:     2019/6/12 下午8:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.dao.impl;

import com.hyperchain.base.Ps;
import com.hyperchain.base.WMap;
import com.hyperchain.dao.BaseDao;
import com.hyperchain.dao.GirlDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/12
 * @since 1.0.0
 */
@Service
public class GirlDaoImpl extends BaseDao implements GirlDao {


    private static final Logger logger = LoggerFactory.getLogger(GirlDaoImpl.class);


    public WMap findGirlById(String id) {
        String sql = "select * from girl where age=?";
        Ps ps = new Ps();
        ps.addString(id);
        return super.getMap(sql, ps);
    }
}