package com.rd4j.common.pojo;

import com.google.common.collect.Lists;
import com.rd4j.common.annotation.Description;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;


/**
 * 分页结果
 *
 * @param <E> 分类集合对象
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
@Description("分页结果")
public class Pagination<E> extends SimplePage implements java.io.Serializable, Paginable {

    public Pagination() {
    }

    public Pagination(Page page, int totalCount) {
        super(page.getPageNo(), page.getPageSize(), totalCount);
    }

    public Pagination(int pageNo, int pageSize, int totalCount) {
        super(pageNo, pageSize, totalCount);
    }

    public Pagination(int pageNo, int pageSize, int totalCount, List<E> list) {
        super(pageNo, pageSize, totalCount);
        this.list = list;
    }

    public Pagination(Page page, int totalCount, List<E> list) {
        this(page, totalCount);
        this.list = list;
    }


    /**
     * 当前页的数据
     */
    @Description("返回数据集")
    protected List<E> list;


    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public <T> Pagination<T> map(Function<E, T> mapper) {
        List<T> retuleList = this.list.stream().map(mapper::apply).collect(Collectors.toList());
        return new Pagination<>(pageNo, pageSize, totalCount, retuleList);
    }

    public static <E> Pagination<E> create(Page page, int totalCount) {
        return new Pagination<>(page, totalCount);
    }

    public static <E> Pagination<E> create(Page page, long totalCount) {
        return new Pagination<>(page, (int) totalCount);
    }

    public static <E> Pagination<E> create(int pageNo, int pageSize, int totalCount) {
        return new Pagination<>(pageNo, pageSize, totalCount);
    }

    public static <E> Pagination<E> create(int pageNo, int pageSize, int totalCount, List<E> list) {
        return new Pagination<>(pageNo, pageSize, totalCount, list);
    }

    public static <E> Pagination<E> create(int pageNo, int pageSize, long totalCount, Supplier<List<E>> supplier) {
        return create(Page.create(pageNo, pageSize), totalCount, supplier);
    }

    public static <E> Pagination<E> create(int pageNo, int pageSize, int totalCount, Supplier<List<E>> supplier) {
        return create(Page.create(pageNo, pageSize), totalCount, supplier);
    }

    public static <E> Pagination<E> create(Page page, int totalCount, List<E> list) {
        return new Pagination<>(page, totalCount, list);
    }

    public static <E> Pagination<E> create(Page page, long totalCount, List<E> list) {
        return new Pagination<>(page, (int) totalCount, list);
    }

    public static <E> Pagination<E> create(Page page, long totalCount, Supplier<List<E>> supplier) {
        return create(page, (int) totalCount, supplier);
    }

    public static <E> Pagination<E> create(Page page, int totalCount, Supplier<List<E>> supplier) {
        if (totalCount <= page.getFirstIndex()) {
            return new Pagination<>(page, totalCount, Lists.newArrayList());
        } else {
            return new Pagination<>(page, totalCount, supplier.get());
        }
    }

    public static <E> Pagination<E> create(Pagination<?> paginable, List<E> list) {
        return new Pagination<>(paginable.getPageNo(), paginable.getPageSize(), paginable.getTotalCount(), list);
    }

    public static <T, E> Pagination<E> create(Pagination<T> paginable, Function<T, E> mapper) {
        return new Pagination<>(paginable.getPageNo(), paginable.getPageSize(), paginable.getTotalCount(), paginable.list.stream().map(
                mapper).collect(Collectors.toList()));
    }

}
