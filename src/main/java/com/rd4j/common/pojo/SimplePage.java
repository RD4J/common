package com.rd4j.common.pojo;


import com.rd4j.common.annotation.Description;

/**
 * 简单的分页参数
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public class SimplePage extends Page implements Paginable {
    /**
     * 默认的每页长度
     */
    public static final int DEFAULT_PAGE_SIZE = 20;

    public SimplePage() {
    }

    public SimplePage(int pageNo, int pageSize, int totalCount) {
        if (totalCount <= 0) {
            this.totalCount = 0;
        } else {
            this.totalCount = totalCount;
        }
        if (pageSize <= 0) {
            this.pageSize = DEFAULT_PAGE_SIZE;
        } else {
            this.pageSize = pageSize;
        }

        int totalPage = getTotalPage();

        if (pageNo < 1)
            this.pageNo = 1;
        else if (pageNo > totalPage)
            this.pageNo = totalPage;
        else
            this.pageNo = pageNo;
    }

    /**
     * 调整分页参数，使合理
     */
    public void adjustPage() {
        if (totalCount <= 0) {
            totalCount = 0;
        }
        if (pageSize <= 0) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        int totalPage = getTotalPage();

        if (pageNo < 1)
            pageNo = 1;
        else if (pageNo > totalPage)
            pageNo = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    @Description("总页数")
    private int totalPage;

    public int getTotalPage() {
        int totalPage = totalCount / pageSize;
        if (totalCount % pageSize != 0 || totalPage == 0) {
            totalPage++;
        }
        return totalPage;
    }

    @Description("是否是第一页")
    private boolean isFirstPage;

    public boolean isFirstPage() {
        return pageNo <= 1;
    }

    public boolean getIsFirstPage() {
        return isFirstPage();
    }

    @Description("是否是最后一页")
    private boolean isLastPage;

    public boolean getIsLastPage() {
        return isLastPage();
    }

    public boolean isLastPage() {
        return pageNo >= getTotalPage();
    }

    @Description("下一页码")
    private int nextPage;

    public int getNextPage() {
        if (isLastPage()) {
            return pageNo;
        } else {
            return pageNo + 1;
        }
    }

    @Description("最后一页")
    private int prePage;

    public int getPrePage() {
        if (isFirstPage()) {
            return pageNo;
        } else {
            return pageNo - 1;
        }
    }

    @Description("数据总条数")
    protected int totalCount = 0;

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public int getFirstResult() {
        return (pageNo - 1) * pageSize;
    }
}
