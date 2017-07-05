package com.atecher.blog.common.model;

import java.io.Serializable;

public class PaginationRequest implements Serializable {

    private static final long serialVersionUID = -3416590373684668797L;

    private Integer offset;

    private Integer limit;

    private String sort;

    private String order;


    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setOffset(Integer offset) {
        this.offset = (offset == null ? 0 : offset);
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = (limit == null ? 10 : limit);
    }

    public Integer getPageNo() {
        return offset / limit + 1;
    }
}
