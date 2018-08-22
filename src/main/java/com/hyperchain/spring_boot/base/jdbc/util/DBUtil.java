package com.hyperchain.spring_boot.base.jdbc.util;

import com.hyperchain.spring_boot.base.Page;
import com.hyperchain.spring_boot.base.jdbc.template.JdbcTemplate;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class DBUtil {
    public static final String DB_TYPE_ORACLE = "ORACLE_TYPE";
    public static final String DB_TYPE_MYSQL = "MYSQL_TYPE";
    public static final String DB_TYPE_SQLSERVER = "SQLSERVER_TYPE";
    public static final String DB_TYPE_PG = "PG_TYPE";
    public static final String DB_TYPE_DB2 = "DB2_TYPE";

    public DBUtil() {
    }

    public static String getPageSQL(String sql, Page page, JdbcTemplate jdbcTemplate) throws SQLException {
        try {
            String driverName = getDriverName(jdbcTemplate);
            StringBuffer pageSQL = null;
            if (driverName.indexOf("MySQL") != -1) {
                pageSQL = new StringBuffer(sql);
                pageSQL.append(" LIMIT ").append((page.getPageNumber() - 1) * page.getPageSize()).append(",").append(page.getPageSize());
                return pageSQL.toString();
            } else {
                if (driverName.indexOf("Oracle") != -1) {
                    pageSQL = new StringBuffer("SELECT * FROM (SELECT T.*, ROWNUM ROWNO FROM (" + sql + ")T WHERE ROWNUM <= " + page.getPageNumber() + "*" + page.getPageSize() + ")" + "WHERE ROWNO>" + (page.getPageNumber() - 1) + "*" + page.getPageSize());
                } else {
                    if (driverName.indexOf("DB2") == -1) {
                        return sql;
                    }

                    pageSQL = new StringBuffer("SELECT * FROM (SELECT T.*, ROW_NUMBER() OVER() AS ROWNO FROM (" + sql + ")T) WHERE ROWNO <= " + page.getPageNumber() + "*" + page.getPageSize() + " AND ROWNO>" + (page.getPageNumber() - 1) + "*" + page.getPageSize());
                }

                return pageSQL.toString();
            }
        } catch (SQLException var5) {
            throw var5;
        }
    }

    public static String getDriverType(JdbcTemplate jdbcTemplate) throws SQLException {
        String driverName = getDriverName(jdbcTemplate);
        String driver = "MYSQL_TYPE";
        if ("Oracle JDBC driver".equals(driverName)) {
            driver = "ORACLE_TYPE";
        } else if (driverName.indexOf("DB2") != -1) {
            driver = "DB2_TYPE";
        }

        return driver;
    }

    public static String getDriverName(JdbcTemplate jdbcTemplate) throws SQLException {
        Connection conn = jdbcTemplate.getDataSource().getConnection();
        DatabaseMetaData dmd = conn.getMetaData();
        conn.close();
        return dmd.getDriverName();
    }
}

