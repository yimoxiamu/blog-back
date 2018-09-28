package com.yimoxiamu.blogback.tools;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;

/**
 * 分页插件
 * @author Tim
 *
 */
public class PageBean<T> {
    private int page;
    private int pageSize=20;
    private long total;
    private List<T> items;

    @JSONField(serialize=false)
    private boolean count = true;
    @JSONField(serialize=false)
    private String orderby;
    public PageBean(){

    }

    public PageBean(List<T> list){
        if(list instanceof Page){
            Page<T> page = (Page<T>)list;
            this.page = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.total = page.getTotal();
            this.items  = new LinkedList<T>(page);
        }
    }

    public static<E> PageBean<E> setUp(int pageNum, int pageSize) {
        return setUp(pageNum, pageSize, true, null);
    }

    public static<E> PageBean<E> setUp(int pageNum, int pageSize, boolean count) {
        return setUp(pageNum, pageSize, count, null);
    }

    public static<E> PageBean<E> setUp(int pageNum, int pageSize, String orderby) {
        return setUp(pageNum, pageSize, true, orderby);
    }

    public static<E> PageBean<E> setUp(int pageNum, int pageSize, boolean count, String orderby) {
        PageBean<E> pageinfo = new PageBean<E>();
        pageinfo.setPage(pageNum);
        pageinfo.setPageSize(pageSize);
        pageinfo.setCount(count);
        pageinfo.setOrderby(orderby);

        return pageinfo;
    }

    @SuppressWarnings("unchecked")
    public <E> PageBean<E> doSelect(final SelectSql select){

        Page<Map<String, Object>> pagehelp = PageHelper.startPage(page, pageSize, count);
        if(orderby != null && orderby.length() > 0) {
            pagehelp.setOrderBy(orderby);
        }

        PageInfo<T> info = pagehelp.doSelectPageInfo(() -> select.doSelect());

        this.total = info.getTotal();
        this.items = info.getList();

        return (PageBean<E>)this;
    }

    public static long count(final SelectSql select){

        long cnt = PageHelper.count(() -> select.doSelect());
        return cnt;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public static interface Select {
        void doSelect();
    }
    public boolean isCount() {
        return count;
    }

    public void setCount(boolean count) {
        this.count = count;
    }

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }
}
