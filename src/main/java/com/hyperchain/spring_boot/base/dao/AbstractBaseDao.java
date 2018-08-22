/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: AbstractBaseDao
 * Author:   lixuanfeng
 * Date:     2018/8/9 上午10:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.base.dao;

import com.hyperchain.spring_boot.base.Page;
import com.hyperchain.spring_boot.base.Ps;
import com.hyperchain.spring_boot.base.WMap;
import com.hyperchain.spring_boot.base.jdbc.template.JdbcTemplate;
import com.hyperchain.spring_boot.base.jdbc.util.DBUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;

import java.io.*;
import java.sql.*;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/8/9
 * @since 1.0.0
 */
public class AbstractBaseDao implements IBaseDao {
    private static final Log logger = LogFactory.getLog(AbstractBaseDao.class);
    public JdbcTemplate jdbcTemplate;
    private Object[] objArr = null;
    private InputStream is = null;
    private static final String blobSequence = "blob,mediumblob,longblob";

    public AbstractBaseDao() {
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<WMap> getMapList(String sql, Ps ps) throws SQLException {
        int size = ps.getParamsList().size();
        Object[] psArr = new Object[size];

        for(int i = 0; i < size; ++i) {
            psArr[i] = ps.getParamsList().get(i);
        }

        return this.jdbcTemplate.query(sql, psArr, new RowMapper() {
            WMap map;

            public WMap mapRow(ResultSet rs, int rowNum) throws SQLException {
                this.map = new WMap();
                String colmunName = null;
                ResultSetMetaData md = rs.getMetaData();

                for(int i = 1; i <= md.getColumnCount(); ++i) {
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

                for(int i = 1; i <= md.getColumnCount(); ++i) {
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
            return (WMap)this.jdbcTemplate.queryForObject(sql, new RowMapper() {
                WMap map;

                public WMap mapRow(ResultSet rs, int rowNum) throws SQLException {
                    this.map = new WMap();
                    String colmunName = null;
                    ResultSetMetaData md = rs.getMetaData();

                    for(int i = 1; i <= md.getColumnCount(); ++i) {
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

        for(int i = 0; i < size; ++i) {
            psArr[i] = ps.getParamsList().get(i);
        }

        try {
            return (WMap)this.jdbcTemplate.queryForObject(sql, psArr, new RowMapper() {
                WMap map;

                public WMap mapRow(ResultSet rs, int rowNum) throws SQLException {
                    this.map = new WMap();
                    String colmunName = null;
                    ResultSetMetaData md = rs.getMetaData();

                    for(int i = 1; i <= md.getColumnCount(); ++i) {
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

        for(int i = 0; i < size; ++i) {
            psArr[i] = ps.getParamsList().get(i);
        }

        List<WMap> dataList = this.jdbcTemplate.query(String.valueOf(pageSQL), psArr, new RowMapper() {
            WMap map;

            public WMap mapRow(ResultSet rs, int rowNum) throws SQLException {
                this.map = new WMap();
                String colmunName = null;
                ResultSetMetaData md = rs.getMetaData();

                for(int i = 1; i <= md.getColumnCount(); ++i) {
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

                for(int i = 1; i <= md.getColumnCount(); ++i) {
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

            for(int i = 0; i < size; ++i) {
                psArr[i] = ps.getParamsList().get(i);
            }

            return psArr;
        }
    }

    public void beginTransaction() throws SQLException {
        this.jdbcTemplate.beginTranstaion();
    }

    public void commit() throws SQLException {
        this.jdbcTemplate.commit();
    }

    public void rollback() throws SQLException {
        this.jdbcTemplate.rollback();
    }

    public void saveMulti(String sql, Ps ps) throws SQLException {
        this.objArr = this.prepareArr(ps);
        LobHandler lobHandler = new DefaultLobHandler();
        this.jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(lobHandler) {
            private File file = null;

            protected void setValues(PreparedStatement psz, LobCreator lobCreator) throws SQLException {
                try {
                    for(int i = 0; i < AbstractBaseDao.this.objArr.length; ++i) {
                        int psIndex = i + 1;
                        if (AbstractBaseDao.this.objArr[i] instanceof File) {
                            this.file = (File)AbstractBaseDao.this.objArr[i];
                            AbstractBaseDao.this.is = new FileInputStream(this.file);
                            lobCreator.setBlobAsBinaryStream(psz, psIndex, AbstractBaseDao.this.is, (int)this.file.length());
                        } else if (AbstractBaseDao.this.objArr[i] instanceof Date) {
                            psz.setDate(psIndex, new java.sql.Date(((Date)AbstractBaseDao.this.objArr[i]).getTime()));
                        } else if (AbstractBaseDao.this.objArr[i] instanceof Timestamp) {
                            psz.setTimestamp(psIndex, (Timestamp)AbstractBaseDao.this.objArr[i]);
                        } else {
                            psz.setString(psIndex, String.valueOf(AbstractBaseDao.this.objArr[i]));
                        }
                    }
                } catch (SQLException var9) {
                    AbstractBaseDao.logger.error("数据库保存文集出现异常！", var9);
                } catch (FileNotFoundException var10) {
                    AbstractBaseDao.logger.error("要保存的文件路径不存在！", var10);
                } finally {
                    lobCreator.close();
                }

            }
        });

        try {
            if (this.is != null) {
                this.is.close();
            }
        } catch (IOException var5) {
            logger.error("文件流关闭异常！", var5);
        }

    }

    public int[] batchUpdate(String sql, final Ps[] psList) {
        int[] updateCounts = this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            Object[] objArr;

            public void setValues(PreparedStatement ps, int index) throws SQLException {
                this.objArr = AbstractBaseDao.this.prepareArr(psList[index]);

                for(int i = 0; i < this.objArr.length; ++i) {
                    int psIndex = i + 1;
                    if (this.objArr[i] instanceof java.sql.Date) {
                        ps.setDate(psIndex, (java.sql.Date)this.objArr[i]);
                    } else if (this.objArr[i] instanceof Timestamp) {
                        ps.setTimestamp(psIndex, (Timestamp)this.objArr[i]);
                    } else {
                        ps.setString(psIndex, String.valueOf(this.objArr[i]));
                    }
                }

            }

            public int getBatchSize() {
                return psList.length;
            }
        });
        return updateCounts;
    }

    public String getDriverType() throws SQLException {
        return DBUtil.getDriverType(this.jdbcTemplate);
    }
}
