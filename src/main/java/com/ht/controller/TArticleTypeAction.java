package com.ht.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.id.SequenceIdentityGenerator.Delegate;

import com.ht.pojo.PagingBean;
import com.ht.pojo.TAgency;
import com.ht.pojo.TArticle;
import com.ht.pojo.TArticleType;
import com.ht.pojo.TEmployee;
import com.ht.service.TArticleTypeService;
import com.opensymphony.xwork2.ActionSupport;

public class TArticleTypeAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private TArticleType tArticleType;
	private List<TArticleType> tArticleTypelist;
	private TArticleTypeService tArticleTypeService;
	private Logger logger = Logger.getLogger(Login_RegirestAction.class);
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TArticleType gettArticleType() {
		return tArticleType;
	}

	public void settArticleType(TArticleType tArticleType) {
		this.tArticleType = tArticleType;
	}

	public List<TArticleType> gettArticleTypelist() {
		return tArticleTypelist;
	}

	public void settArticleTypelist(List<TArticleType> tArticleTypelist) {
		this.tArticleTypelist = tArticleTypelist;
	}

	public TArticleTypeService gettArticleTypeService() {
		return tArticleTypeService;
	}

	public void settArticleTypeService(TArticleTypeService tArticleTypeService) {
		this.tArticleTypeService = tArticleTypeService;
	}
	public String pagearticletype() throws Exception{
		paginglist();
		return "pagearticletype";
	}
	public String addarticletype() throws Exception{
		tArticleTypeService.add(tArticleType);
		paginglist();
		return "addarticletype";
	}
	public String initupdatearticletype() throws Exception{
		tArticleType = tArticleTypeService.queryById(tArticleType.getIdString());
		return "initupdatearticletype";
	}
	public String updatearticletype() throws Exception{
		tArticleTypeService.update(tArticleType);
		paginglist();
		return "updatearticletype";
	}
	public void paginglist() throws Exception {
		PagingBean page = new PagingBean();
		page.setPagebarsize(10);
		page.setPagebarsum(tArticleTypeService.count("",""));
		String currentpage = request.getParameter("currentpage");
		//操作
		String handle = request.getParameter("handle");
		if(currentpage==null || currentpage.equals("")){
			//当前页为第一页
			page.setCurrentpage(1);
		}else {
			page.setCurrentpage(Integer.parseInt(currentpage));
		}
		if(handle==null || handle.equals("")){
			if(currentpage==null || currentpage.equals("")){
				//当前页为第一页
				page.setCurrentpage(1);
			}else{	//当前页为第一页
				page.setCurrentpage(Integer.parseInt(currentpage));
			}
			//当前页的操作
		}else {
			page.setHandle(handle);
		}
		if(page.getPagebarsum()==0){
			page.setCurrentpage(0);
			page.setStarlocal(0);
			page.setPagebarsize(0);
		}
		DetachedCriteria dc = DetachedCriteria.forClass(TArticleType.class);
		tArticleTypelist = tArticleTypeService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
		request.setAttribute("pager", page);
	}
	public String deletearticletype() throws Exception{
		tArticleTypeService.delete(tArticleType);
		return "deletearticletype";
	}
	public String deletemanyarticletype() throws Exception{
		String idstring[]= id.split(",");
		for(int i=0;i<idstring.length;i++){
			tArticleType = new TArticleType();
			tArticleType.setIdString(idstring[i]);
			logger.info("Ip为："+request.getRemoteAddr()+"的用户正在删除多片资讯类别,资讯类别"+i+"编号为"+idstring[i]+"，当前时间为："+new Date().toLocaleString());
			tArticleTypeService.delete(tArticleType);
		}
		paginglist();
		return "deletemanyarticletype";
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
			
	}

}
