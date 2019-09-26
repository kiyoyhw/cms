package com.ank.cms.model.base;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = -3915666721968467471L;
    private int pageNum;
    private int pageSize;
    private long totalCount;
    private int totalPageCount;
    private List<T> result;

    public PageResult() {
    }

    public PageResult(List<T> result, long totalCount) {
        this.result = result;
        this.totalCount = totalCount;
    }

    public PageResult(int pageNum, int pageSize, long totalCount, int totalPageCount, List<T> result) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPageCount = totalPageCount;
        this.result = result;
    }

    public boolean getFirstPage() {
        return this.getPageNum() == 1;
    }

    public long getPrevPage() {
        return (long) Math.max(1, this.getPageNum() - 1);
    }

    public long getNextPage() {
        return (long) (this.getPageNum() + 1);
    }

    public boolean getLastPage() {
        return this.getPageNum() >= this.getTotalPageCount();
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPageCount() {
        return this.totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public List<T> getResult() {
        return this.result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

}