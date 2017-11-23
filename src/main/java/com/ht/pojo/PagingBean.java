package com.ht.pojo;

import java.io.Serializable;

public class PagingBean implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		//总页数
	private int sumpage;
	//每页的记录条数
	private int pagebarsize;
	//当前页
	private int currentpage;
	//总记录条数
	private int pagebarsum;
	//相关的操作
	private String handle;
	//起始操作位置
	private int starlocal;
	public int getStarlocal() {
		starlocal = (currentpage-1)*pagebarsize;
		if((starlocal+pagebarsize)>=pagebarsum){
			if(pagebarsum-pagebarsize<0){
				starlocal=0;
			}
		}
		return starlocal;
	}
	public void setStarlocal(int starlocal) {
		this.starlocal = starlocal;
	}
	public int getSumpage() {
		return sumpage;
	}
	public void setSumpage(int sumpage) {
		this.sumpage = sumpage;
	}
	public int getPagebarsize() {
		return pagebarsize;
	}
	public void setPagebarsize(int pagebarsize) {
		this.pagebarsize = pagebarsize;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getPagebarsum() {
		return pagebarsum;
	}
	public void setPagebarsum(int pagebarsum) {
		//计算页的总数
		sumpage = (int)Math.ceil((float)pagebarsum/(float)pagebarsize);
		this.pagebarsum = pagebarsum;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		//代表选择的是第一页
		if(handle.equals("firstpage")){
			currentpage=1;
		}else if (handle.equals("uppage")) {
			//代表上一页
			if(currentpage>1){
				currentpage--;
			}else {
				currentpage=1;
			}
		}else if (handle.equals("downpage")) {
			//代表下一页
			if(currentpage<sumpage){
				currentpage++;
			}else {
				currentpage = sumpage;
			}
		}else if (handle.equals("lastpage")) {
			currentpage = sumpage;
		}else {
			currentpage=1;
		}
		this.handle = handle;
	} 
}
