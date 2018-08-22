package com.hyperchain.spring_boot.base.dao;

import com.hyperchain.spring_boot.base.Page;
import com.hyperchain.spring_boot.base.Ps;
import com.hyperchain.spring_boot.base.WMap;
import org.springframework.dao.DataAccessException;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

public interface IBaseDao {
    Page getPageList(String var1, Ps var2, Page var3) throws SQLException;

    Page getPageList(String var1, Page var2) throws SQLException;

    List<WMap> getMapList(String var1, Ps var2) throws SQLException;

    List<WMap> getMapList(String var1) throws SQLException;

    WMap getMap(String var1) throws SQLException;

    WMap getMap(String var1, Ps var2) throws DataAccessException;

    int save(String var1) throws SQLException;

    int save(String var1, Ps var2) throws SQLException;

    void saveMulti(String var1, Ps var2) throws FileNotFoundException, SQLException;

    int delete(String var1, Ps var2) throws SQLException;

    int update(String var1, Ps var2) throws SQLException;

    int update(String var1) throws SQLException;

    void beginTransaction() throws SQLException;

    void commit() throws SQLException;

    void rollback() throws SQLException;

    int[] batchUpdate(String var1, Ps[] var2);

    String getDriverType() throws SQLException;
}
