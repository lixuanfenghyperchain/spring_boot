/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: Page
 * Author:   lixuanfeng
 * Date:     2018/8/8 上午11:30
 * Description: 分页实体
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 封装分页对象
 *
 * @author lixuanfeng
 * @create 2018/8/8
 * @since 1.0.0
 */
public class Page {


    private int page;   //当前页
    private int totalRows;   //总行数
    private int pages;    //总页数
    private int pageSize; //每页的大小
    private List list = new ArrayList();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List getList() {
        if (list == null) {
            list = new ArrayList();
        }
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", totalRows=" + totalRows +
                ", pages=" + pages +
                ", pageSize=" + pageSize +
                ", list=" + list +
                '}';
    }
}