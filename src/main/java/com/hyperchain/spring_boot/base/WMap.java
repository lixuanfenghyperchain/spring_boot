/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: WMap
 * Author:   lixuanfeng
 * Date:     2018/8/9 上午10:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.base;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/8/9
 * @since 1.0.0
 */

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WMap extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 2271309536847865360L;

    public WMap() {
    }

    public WMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public void setString(String key, String value) {
        super.put(key, value);
    }

    public void setWMap(String key, WMap value) {
        super.put(key, value);
    }

    public void setInt(String key, Integer value) {
        super.put(key, value);
    }

    public void setFloat(String key, float value) {
        super.put(key, value);
    }

    public void setLong(String key, Long value) {
        super.put(key, value);
    }

    public void setMap(String key, Map<?, ?> value) {
        super.put(key, value);
    }

    public Map<?, ?> getMap(String key) {
        return (Map) super.get(key);
    }

    public void setDouble(String key, double value) {
        super.put(key, value);
    }

    public void setDate(String key, Date value) {
        super.put(key, value);
    }

    public void setTimeStamp(String key, Timestamp value) {
        super.put(key, value);
    }

    public void setList(String key, List<?> list) {
        super.put(key, list);
    }

    public WMap getWMap(String key) {
        Object object = super.get(key);
        return object == null ? null : (WMap) object;
    }

    public Integer getInt(String key) {
        Object object = super.get(key);
        return object == null ? 0 : (Integer) object;
    }

    public long getLong(String key) {
        Object object = super.get(key);
        return object == null ? 0L : (Long) object;
    }

    public Float getFloat(String key) {
        Object object = super.get(key);
        return object == null ? 0.0F : (Float) object;
    }

    public Double getDouble(String key) {
        Object object = super.get(key);
        return object == null ? 0.0D : Double.parseDouble(String.valueOf(object));
    }

    public Date getDate(String key) {
        Object object = super.get(key);
        return object == null ? null : (Date) object;
    }

    public String getString(String key) {
        Object object = super.get(key);
        return object == null ? null : String.valueOf(object);
    }

    public void setObject(String key, Object object) {
        super.put(key, object);
    }

    public Object getObject(String key) {
        return super.get(key);
    }

    public InputStream getInputStream(String key) {
        return (InputStream) super.get(key);
    }

    public void setInputStream(String key, InputStream value) {
        super.put(key, value);
    }

    public void setPage(Page page) {
        super.putAll(page);
    }
}
