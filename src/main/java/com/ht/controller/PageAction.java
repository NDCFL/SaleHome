package com.ht.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ht.pojo.TActivity;
import com.ht.pojo.TArticle;
import com.ht.pojo.TPage;
import com.ht.pojo.TUser;
import com.ht.service.ActivityService;
import com.ht.service.ArticleService;
import com.ht.service.PageService;
import com.opensymphony.xwork2.ActionSupport;

public class PageAction  extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest reques;
	private HttpServletResponse response;
	private TPage page;
	public List<TArticle> getArticlelist() {
		return articlelist;
	}
	public void setArticlelist(List<TArticle> articlelist) {
		this.articlelist = articlelist;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	private PageService pageService;
	private List<TPage> pagelist;
	private List<TArticle> articlelist;
	private ArticleService  articleService;
	public List<TActivity> getActivitylist() {
		return activitylist;
	}
	public void setActivitylist(List<TActivity> activitylist) {
		this.activitylist = activitylist;
	}
	public ActivityService getActivityService() {
		return activityService;
	}
	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}
	private List<TActivity> activitylist;
	private ActivityService activityService;
	public TPage getPage() {
		return page;
	}
	public void setPage(TPage page) {
		this.page = page;
	}
	public PageService getPageService() {
		return pageService;
	}
	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}
	public List<TPage> getPagelist() {
		return pagelist;
	}
	public void setPagelist(List<TPage> pagelist) {
		this.pagelist = pagelist;
	}
	public String addpage() throws Exception{
		articlelist = articleService.facetaricle();
		return "addpage";
	}
	public String afterpage() throws Exception{
		HttpSession session = reques.getSession();
		TUser user = (TUser)session.getAttribute("user");
		List<TPage> list = pageService.findpage("useridString", user.getIdString());
		if(list.size()==0){
			page.setUseridString(user.getIdString());
			pageService.add(page);
		}
		articlelist = articleService.facetaricle();
		DetachedCriteria dc4 = DetachedCriteria.forClass(TActivity.class);
		dc4.add(Restrictions.eq("statusInt", 1));
		activitylist = activityService.pagelist(dc4, 0, 2);
		return "afterpage";
	}
	public String showpage() throws Exception{
		List<TPage> list = pageService.findpage("useridString", page.getUseridString());
		page = list.get(0);
		return "showpage";
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.reques=request;
		
	}

}
