package com.ht.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.alibaba.fastjson.JSON;
import com.ht.pojo.PagingBean;
import com.ht.pojo.TGetPrize;
import com.ht.pojo.TUser;
import com.ht.service.GetPrizeService;
import com.opensymphony.xwork2.ActionSupport;

public class GetPrizeAction extends ActionSupport implements ServletResponseAware,ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private List<TGetPrize> getprizelist;
	private GetPrizeService getPrizeService;
	private String name;
	private TGetPrize prize;
	public TGetPrize getPrize() {
		return prize;
	}
	public void setPrize(TGetPrize prize) {
		this.prize = prize;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<TGetPrize> getGetprizelist() {
		return getprizelist;
	}
	public void setGetprizelist(List<TGetPrize> getprizelist) {
		this.getprizelist = getprizelist;
	}
	public GetPrizeService getGetPrizeService() {
		return getPrizeService;
	}
	public void setGetPrizeService(GetPrizeService getPrizeService) {
		this.getPrizeService = getPrizeService;
	}
	
	public String pagegetprize() throws Exception{
		paginglist();
		return "pagegetprize";
	}
	public String addgetprize() throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		TUser t = (TUser)session.getAttribute("user");
		List<TGetPrize> tg = getPrizeService.findlist("useridString", t.getPhoneString());
		if(tg.size()==0){
			prize = new TGetPrize();
			prize.setCreatedTime(new Date());
			prize.setPrizetypeInt(0);
			prize.setPrizenameString(name);
			prize.setUseridString(t.getPhoneString());
			getPrizeService.add(prize);
			out.print(JSON.toJSON("领取成功"));
			return null;
		}else{
			out.print(JSON.toJSON("你已经抽过奖了"));
			return null;
		}
		
	}
	public String deletegetprize() throws Exception{
		getPrizeService.delete(prize);
		return "deletegetprize";
	}
	public String pagecustomerprize() throws Exception{
		pagingcustomerlist();
		return "pagecustomerprize";
	}
	public String updategetprizestatus(){
		try {
			System.out.println(prize.getIdString()+"===================");
			getPrizeService.update(prize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "updategetprizestatus";
	}
	public void paginglist() throws Exception {
		HttpSession session = request.getSession();
		TUser t = (TUser)session.getAttribute("user");
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(10);
		page.setPagebarsum(getPrizeService.count("useridString",t.getPhoneString()));
		//当前页
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
				if(currentpage==null || currentpage.equals("")){
					page.setCurrentpage(1);
				}else{	
					page.setCurrentpage(Integer.parseInt(currentpage));
				}
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
		DetachedCriteria dc = DetachedCriteria.forClass(TGetPrize.class);
		dc.add(Restrictions.eq("useridString",t.getPhoneString()));
		getprizelist = getPrizeService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
		request.setAttribute("pager", page);
	}
	public void pagingcustomerlist() throws Exception {
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(4);
		page.setPagebarsum(getPrizeService.count("useridString",request.getParameter("useridString")));
		//当前页
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
		if((page.getStarlocal()+page.getPagebarsize())>=page.getPagebarsum()){
			DetachedCriteria dc = DetachedCriteria.forClass(TGetPrize.class);
			dc.add(Restrictions.eq("useridString",request.getParameter("useridString")));
			getprizelist = getPrizeService.pagelist(dc,(page.getPagebarsum()-page.getPagebarsize()), page.getPagebarsize());
			page.setStarlocal(page.getPagebarsum()-page.getPagebarsize());
			request.setAttribute("pager", page);
			return;
		}else{
			DetachedCriteria dc = DetachedCriteria.forClass(TGetPrize.class);
			dc.add(Restrictions.eq("useridString",request.getParameter("useridString")));
			getprizelist = getPrizeService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
			request.setAttribute("pager", page);
		}
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}

	
}
