/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: BaseDao
 * Author:   lixuanfeng
 * Date:     2018/8/8 上午10:24
 * Description: 持久层基础类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.dao.basedao;

import com.hyperchain.spring_boot.vo.Page;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈持久层基础类〉
 *
 * @author lixuanfeng
 * @create 2018/8/8
 * @since 1.0.0
 */
@Component
public class BaseDao {
    @Autowired
    private EntityManager entityManager;

    /**
     * 查询一条记录,没有参数
     *
     * @param sql sql
     * @return
     */
    public Map getMap(String sql) {
        Query nativeQuery = entityManager.createNativeQuery(sql.toString());
        nativeQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        Map map = (Map) nativeQuery.getResultList().get(0);
        return map;
    }

    /**
     * 查询一条记录 带参数
     *
     * @param sql
     * @param list
     * @return
     */

    public Map getMap(String sql, List<Object> list) {
        Query nativeQuery = entityManager.createNativeQuery(sql.toString());
        nativeQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                nativeQuery.setParameter(i + 1, list.get(i));
            }
        }
        Map map = (Map) nativeQuery.getResultList().get(0);
        return map;
    }

    /**
     * 查询多条记录 带参数
     *
     * @param sql
     * @param list
     * @return
     */
    public List<Map> getMapList(String sql, List<Object> list) {
        Query nativeQuery = entityManager.createNativeQuery(sql.toString());
        nativeQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        if (list.size() != 0) {
            if (sql.isEmpty() && !sql.contains("?")) {
                throw new RuntimeException("sql 有误");
            }
            for (int i = 0; i < list.size(); i++) {
                nativeQuery.setParameter(i + 1, list.get(i));
            }
        } else {
            if (sql.isEmpty() && sql.contains("?")) {
                throw new RuntimeException("sql 有误");
            }
        }
        List<Map> mapList = nativeQuery.getResultList();
        return mapList;
    }

    /**
     * 查询多条记录 不带参数
     *
     * @param sql
     * @return
     */
    public List<Map> getMapList(String sql) {
        Query nativeQuery = entityManager.createNativeQuery(sql.toString());
        nativeQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Map> mapList = nativeQuery.getResultList();
        return mapList;
    }


    /**
     * 分页查询多条记录 不带参数
     *
     * @param sql
     * @return
     */
    public Page getPage(String sql, Page page) {
        Query nativeQuery = entityManager.createNativeQuery(sql.toString());
        nativeQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        int pageNum = page.getPage(); //当前页数
        int pageSzie = page.getPageSize();//每页的条数
        nativeQuery.setFirstResult(pageNum * pageSzie);
        nativeQuery.setMaxResults(pageSzie);
        List<Map> mapList = nativeQuery.getResultList();
        //查询总条数
        //查询总条数
        int from = sql.toUpperCase().indexOf("FROM");//
        String countSql = sql.toUpperCase().substring(from);
        countSql = "select count(*)  " + countSql;
        Query countQuery = entityManager.createNativeQuery(countSql);
        BigInteger count = (BigInteger) countQuery.getResultList().get(0);
        page.setTotalRows(count.intValue());
        page.setList(mapList);
        return page;
    }

    /**
     * 分页查询多条记录 带参数
     *
     * @param sql
     * @return
     */
    public Page getPage(String sql, Page page, List<Object> list) {
        Query nativeQuery = entityManager.createNativeQuery(sql.toString());
        nativeQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                nativeQuery.setParameter(i + 1, list.get(i));
            }
        }
        int pageNum = page.getPage(); //当前页数
        int pageSzie = page.getPageSize();//每页的条数
        nativeQuery.setFirstResult(pageNum * pageSzie);
        nativeQuery.setMaxResults(pageSzie);
        List<Map> mapList = nativeQuery.getResultList();
        //查询总条数
        //查询总条数
        int from = sql.toUpperCase().indexOf("FROM");//
        String countSql = sql.toUpperCase().substring(from);
        countSql = "select count(*)  " + countSql;
        Query countQuery = entityManager.createNativeQuery(countSql);
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                countQuery.setParameter(i + 1, list.get(i));
            }
        }
        BigInteger count = (BigInteger) countQuery.getResultList().get(0);
        page.setTotalRows(count.intValue());
        page.setList(mapList);
        return page;
    }


}