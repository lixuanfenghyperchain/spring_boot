/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: Page
 * Author:   lixuanfeng
 * Date:     2018/8/9 上午10:35
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
import java.util.List;

public class Page extends WMap {
    public Page() {
    }

    public List<?> getDataList() {
        return (List)super.get("dataList");
    }

    public void setDataList(List<?> dataList) {
        super.setList("dataList", dataList);
    }

    public Integer getPageNumber() {
        return Integer.parseInt(super.getString("pageNumber"));
    }

    public void setPageNumber(String pageNumber) {
        if (pageNumber != null && !"".equals(pageNumber)) {
            super.setString("pageNumber", pageNumber);
        } else {
            super.setString("pageNumber", "1");
        }

    }

    public Integer getPageSize() {
        String pageSize = super.getString("pageSize");
        return pageSize != null && !"".equals(pageSize) ? Integer.parseInt(pageSize) : 10;
    }

    public void setPageSize(String pageSize) {
        if (pageSize != null && !"".equals(pageSize)) {
            super.setString("pageSize", pageSize);
        } else {
            super.setString("pageSize", "10");
        }

    }

    public String getTotalSize() {
        return super.getString("totalSize");
    }

    public void setTotalSize(Integer totalSize) {
        super.setString("totalSize", String.valueOf(totalSize));
    }
}