/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: BaseDao
 * Author:   lixuanfeng
 * Date:     2019/6/12 下午8:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.dao;

import com.hyperchain.base.Page;
import com.hyperchain.base.Ps;
import com.hyperchain.base.WMap;
import com.hyperchain.utils.DBUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/12
 * @since 1.0.0
 */
public class BaseDao {
    private static final Log logger = LogFactory.getLog(BaseDao.class);
    @Autowired
    public JdbcTemplate jdbcTemplate;

    public BaseDao() {
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<WMap> getMapList(String sql, Ps ps) throws SQLException {
        int size = ps.getParamsList().size();
        Object[] psArr = new Object[size];

        for (int i = 0; i < size; ++i) {
            psArr[i] = ps.getParamsList().get(i);
        }

        return this.jdbcTemplate.query(sql, psArr, new RowMapper() {
            WMap map;

            public WMap mapRow(ResultSet rs, int rowNum) throws SQLException {
                this.map = new WMap();
                String colmunName = null;
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); ++i) {
                    colmunName = md.getColumnLabel(i);
                    if ("blob".equals(md.getColumnTypeName(i).toLowerCase())) {
                        this.map.setObject(colmunName.toLowerCase(), rs.getBinaryStream(colmunName));
                    } else {
                        this.map.setObject(colmunName.toLowerCase(), rs.getObject(colmunName));
                    }
                }

                return this.map;
            }
        });
    }

    public List<WMap> getMapList(String sql) throws SQLException {
        return this.jdbcTemplate.query(sql, new RowMapper() {
            WMap map;

            public WMap mapRow(ResultSet rs, int rowNum) throws SQLException {
                this.map = new WMap();
                String colmunName = null;
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); ++i) {
                    colmunName = md.getColumnLabel(i);
                    if ("blob".equals(md.getColumnTypeName(i).toLowerCase())) {
                        this.map.setObject(colmunName.toLowerCase(), rs.getBinaryStream(colmunName));
                    } else {
                        this.map.setObject(colmunName.toLowerCase(), rs.getObject(colmunName));
                    }
                }

                return this.map;
            }
        });
    }

    public WMap getMap(String sql) throws SQLException {
        try {
            return (WMap) this.jdbcTemplate.queryForObject(sql, new RowMapper() {
                WMap map;

                public WMap mapRow(ResultSet rs, int rowNum) throws SQLException {
                    this.map = new WMap();
                    String colmunName = null;
                    ResultSetMetaData md = rs.getMetaData();

                    for (int i = 1; i <= md.getColumnCount(); ++i) {
                        colmunName = md.getColumnLabel(i);
                        if ("blob".equals(md.getColumnTypeName(i).toLowerCase())) {
                            this.map.setObject(colmunName.toLowerCase(), rs.getBinaryStream(colmunName));
                        } else {
                            this.map.setObject(colmunName.toLowerCase(), rs.getObject(colmunName));
                        }
                    }

                    return this.map;
                }
            });
        } catch (EmptyResultDataAccessException var3) {
            return null;
        } catch (DataAccessException var4) {
            throw var4;
        }
    }

    public WMap getMap(String sql, Ps ps) {
        int size = ps.getParamsList().size();
        Object[] psArr = new Object[size];

        for (int i = 0; i < size; ++i) {
            psArr[i] = ps.getParamsList().get(i);
        }

        try {
            return (WMap) this.jdbcTemplate.queryForObject(sql, psArr, new RowMapper() {
                WMap map;

                public WMap mapRow(ResultSet rs, int rowNum) throws SQLException {
                    this.map = new WMap();
                    String colmunName = null;
                    ResultSetMetaData md = rs.getMetaData();

                    for (int i = 1; i <= md.getColumnCount(); ++i) {
                        colmunName = md.getColumnLabel(i);
                        if ("blob,mediumblob,longblob".contains(md.getColumnTypeName(i).toLowerCase())) {
                            this.map.setInputStream(colmunName.toLowerCase(), rs.getBinaryStream(colmunName));
                        } else {
                            this.map.setObject(colmunName.toLowerCase(), rs.getObject(colmunName));
                        }
                    }

                    return this.map;
                }
            });
        } catch (EmptyResultDataAccessException var6) {
            return null;
        } catch (DataAccessException var7) {
            throw var7;
        }
    }

    public Page getPageList(String sql, Ps ps, Page page) throws SQLException {
        String pageSQL = DBUtil.getPageSQL(sql, page, this.jdbcTemplate);
        int size = ps.getParamsList().size();
        Object[] psArr = new Object[size];

        for (int i = 0; i < size; ++i) {
            psArr[i] = ps.getParamsList().get(i);
        }

        List<WMap> dataList = this.jdbcTemplate.query(String.valueOf(pageSQL), psArr, new RowMapper() {
            WMap map;

            public WMap mapRow(ResultSet rs, int rowNum) throws SQLException {
                this.map = new WMap();
                String colmunName = null;
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); ++i) {
                    colmunName = md.getColumnLabel(i);
                    if ("blob,mediumblob,longblob".contains(md.getColumnTypeName(i).toLowerCase())) {
                        this.map.setObject(colmunName.toLowerCase(), rs.getBinaryStream(colmunName));
                    } else {
                        this.map.setObject(colmunName.toLowerCase(), rs.getObject(colmunName));
                    }
                }

                return this.map;
            }
        });
        WMap sizeMap = this.getMap("SELECT COUNT(1) AS ROWCOUNT FROM(" + sql + ") CTABLE", ps);
        page.setTotalSize(Integer.parseInt(sizeMap.getString("rowcount")));
        page.setDataList(dataList);
        return page;
    }

    public Page getPageList(String sql, Page page) throws SQLException {
        String pageSQL = DBUtil.getPageSQL(sql, page, this.jdbcTemplate);
        List<WMap> dataList = this.jdbcTemplate.query(pageSQL, new RowMapper() {
            WMap map;

            public WMap mapRow(ResultSet rs, int rowNum) throws SQLException {
                this.map = new WMap();
                String colmunName = null;
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); ++i) {
                    colmunName = md.getColumnLabel(i);
                    if ("blob".equals(md.getColumnTypeName(i).toLowerCase())) {
                        this.map.setObject(colmunName.toLowerCase(), rs.getBinaryStream(colmunName));
                    } else {
                        this.map.setObject(colmunName.toLowerCase(), rs.getObject(colmunName));
                    }
                }

                return this.map;
            }
        });
        WMap sizeMap = this.getMap("SELECT COUNT(1) AS ROWCOUNT FROM(" + sql + ") CTABLE");
        page.setTotalSize(Integer.parseInt(sizeMap.getString("rowcount")));
        page.setDataList(dataList);
        return page;
    }

    public int save(String sql, Ps ps) throws SQLException {
        return this.update(sql, ps);
    }

    public int save(String sql) throws SQLException {
        return this.update(sql);
    }

    public int update(String sql, Ps ps) throws SQLException {
        if (sql == null) {
            throw new SQLException("SQL语句不合法：" + sql);
        } else {
            return this.jdbcTemplate.update(sql, this.prepareArr(ps));
        }
    }

    public int update(String sql) throws SQLException {
        if (sql == null) {
            throw new SQLException("SQL语句不合法：" + sql);
        } else {
            return this.jdbcTemplate.update(sql);
        }
    }

    public int delete(String sql, Ps ps) throws SQLException {
        return this.jdbcTemplate.update(sql, this.prepareArr(ps));
    }

    private Object[] prepareArr(Ps ps) throws SQLException {
        if (ps == null) {
            throw new SQLException("ps参数不能为空！：");
        } else {
            int size = ps.getParamsList().size();
            Object[] psArr = new Object[size];

            for (int i = 0; i < size; ++i) {
                psArr[i] = ps.getParamsList().get(i);
            }

            return psArr;
        }
    }

    public String getDriverType() throws SQLException {
        return DBUtil.getDriverType(this.jdbcTemplate);
    }
}