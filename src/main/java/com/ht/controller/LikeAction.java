package com.ht.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.ht.pojo.TBaobiao;
import com.ht.pojo.TBuildings;
import com.ht.pojo.TLike;
import com.ht.pojo.TUser;
import com.ht.service.LikeService;
import com.opensymphony.xwork2.ActionSupport;

public class LikeAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private TLike like;
	private LikeService likeService;
	private List<TLike> likelist;
	private TUser user;
	private String id;
	private TBuildings loupan;
	public TBuildings getLoupan() {
		return loupan;
	}
	public void setLoupan(TBuildings loupan) {
		this.loupan = loupan;
	}

	private int number=0;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TUser getUser() {
		return user;
	}
	public void setUser(TUser user) {
		this.user = user;
	}
	public TLike getLike() {
		return like;
	}
	public void setLike(TLike like) {
		this.like = like;
	}
	public LikeService getLikeService() {
		return likeService;
	}
	public void setLikeService(LikeService likeService) {
		this.likeService = likeService;
	}
	public List<TLike> getLikelist() {
		return likelist;
	}
	public void setLikelist(List<TLike> likelist) {
		this.likelist = likelist;
	}
	public String pagelike() throws Exception{
		paginglist();
		return "pagelike";
	}
	public String deletelike() throws Exception{
		HttpSession session = request.getSession();
		TUser user = (TUser)session.getAttribute("user");
		List<TLike> list = likeService.likelist("userIdString", user.getIdString());
		like = list.get(0);
		likeService.delete(like);
		return "deletelike";
	}
	public String deletemanylike() throws Exception{
		String idstring[]= id.split(",");
		for(int i=0;i<idstring.length;i++){
			like = new TLike();
			like.setIdString(idstring[i]);
			likeService.delete(like);
		}
		paginglist();
		return "deletemanylike";
	}
	public String baobiao() throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<TBaobiao> l = new ArrayList<TBaobiao>();
		@SuppressWarnings("rawtypes")
		List list = likeService.baobiao();
		for(int i=0;i<list.size();i++){
			TBaobiao baobiao = new TBaobiao();
			double d[]=new double[12];
			Object [] object = (Object [])list.get(i);
			for(int j=0;j<12;j++){
				d[j]=Double.parseDouble(object[j+1].toString());
				
			}
			baobiao.setName(object[0].toString());
			baobiao.setData(d);
			l.add(baobiao);
		}
		out.print(JSON.toJSONString(l));
		return null;
		
	}
	public String checklike() throws Exception{
		HttpSession session = request.getSession();
		TUser user = (TUser)session.getAttribute("user");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		number= likeService.count("userIdString",user.getIdString());
		out.print(number);
		return null;
	}
	public String addlike() throws Exception{
		System.out.println("sadfsd");
		HttpSession session = request.getSession();
		TUser user = (TUser)session.getAttribute("user");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		like = new TLike();
		like.setBuildingsIdString(loupan.getIdString());
		like.setUserIdString(user.getIdString());
		like.setCreatedTime(new Date());
		number= likeService.count("userIdString",user.getIdString());
		if(number>=1){
			out.print(number);
			return null;
		}else{
			likeService.add(like);
			out.print(number);
			return null;
		}
	}
	public void paginglist() throws Exception {
		HttpSession session = request.getSession();
		TUser e = (TUser)session.getAttribute("user");
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(10);
		page.setPagebarsum(likeService.count("userIdString", e.getIdString()));
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
				page.setCurrentpage(1);
			}else{	
				page.setCurrentpage(Integer.parseInt(currentpage));
			}
		}else {
			page.setHandle(handle);
		}
		if(page.getPagebarsum()==0){
			page.setCurrentpage(0);
			page.setStarlocal(0);
			page.setPagebarsize(0);
		}
		DetachedCriteria dc = DetachedCriteria.forClass(TLike.class);
		dc.add(Restrictions.eq("employeeId", e.getIdString()));
		likelist = likeService.pagelist(dc,(page.getPagebarsum()-page.getPagebarsize()), page.getPagebarsize());
		request.setAttribute("pager", page);
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
