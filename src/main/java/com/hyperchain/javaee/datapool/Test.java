/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Test
 * Author:   lixuanfeng
 * Date:     2019/6/3 下午5:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javaee.datapool;

import com.sun.media.sound.SoftTuning;

import java.sql.SQLException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/3
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) throws SQLException {
        JdbcPool jdbcPool=new JdbcPool();
        jdbcPool.getConnection();
        jdbcPool.getConnection();
        jdbcPool.getConnection();
        jdbcPool.getConnection();
        jdbcPool.getConnection();
        jdbcPool.getConnection();
        jdbcPool.getConnection();
        jdbcPool.getConnection();
        jdbcPool.getConnection();
        jdbcPool.getConnection().close();
    }

}