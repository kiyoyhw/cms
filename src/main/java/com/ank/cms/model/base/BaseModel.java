package com.ank.cms.model.base;

import java.io.Serializable;

public class BaseModel implements Serializable {
    private String sortByFiled;//排序字段
    private String sortType;//asc desc

    public String getSortByFiled() {
        return sortByFiled;
    }

    public void setSortByFiled(String sortByFiled) {
        this.sortByFiled = sortByFiled;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }
}
