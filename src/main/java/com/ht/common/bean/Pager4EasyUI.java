package com.ht.common.bean;

import java.util.List;

public class Pager4EasyUI<T> {
	
	private int page;
	private int pageSize;
	
	private int total;
	private List<T> rows;
	
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
	
	public int getBeginIndex() {
		return (page - 1) * pageSize;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
