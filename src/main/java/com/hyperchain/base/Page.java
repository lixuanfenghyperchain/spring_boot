package com.hyperchain.base;

import java.util.List;

public class Page extends WMap {
    public Page() {
    }

    public List<?> getDataList() {
        return (List) super.get("dataList");
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
