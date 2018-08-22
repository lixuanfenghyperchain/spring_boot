package com.hyperchain.spring_boot.base.jdbc.template;

import org.springframework.jdbc.core.JdbcOperations;

import javax.sql.DataSource;

/**
 * jdbc 模版接口 提供事务操作 以及获取数据源
 * JdbcOperations  操作数据库的一些方法
 */
public interface JdbcTemplate extends JdbcOperations {
    void beginTranstaion();

    void commit();

    void rollback();

    DataSource getDataSource();
}

