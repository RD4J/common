package com.rd4j.common.pojo;


import com.rd4j.common.annotation.Description;

import java.io.Serializable;

/**
 * 分页参数
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 * @see Sorting
 */
@Description("分页参数")
public class Page implements Serializable {

    @Description({"每页多少条",
            "默认：10"})
    protected int pageSize = 10;

    @Description({"页码",
            "默认：1"})
    protected int pageNo = 1;

    public Page() {
        super();
    }

    public Page(int pageNo, int pageSize) {
        super();
        this.pageSize = pageSize;
        this.pageNo = pageNo;
    }

    public static Page create(int pageNo, int pageSize) {
        return new Page(pageNo, pageSize);
    }

    public int getPageSize() {
        return pageSize;
    }

    public Page setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getPageNo() {
        return pageNo;
    }

    public Page setPageNo(int pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public int getFirstIndex() {
        return (pageNo - 1) * pageSize;
    }

    public String toMysql() {
        return " Limit " + getFirstIndex()
                + ", "
                + getPageSize();
    }

    @Override
    public String toString() {
        return "Page [pageSize=" + pageSize
                + ", pageNo="
                + pageNo
                + "]";
    }

}
