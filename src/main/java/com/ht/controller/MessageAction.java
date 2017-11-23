package com.ht.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ht.pojo.PagingBean;
import com.ht.pojo.TAgency;
import com.ht.pojo.TBuilding;
import com.ht.pojo.TMessage;
import com.ht.pojo.TUser;
import com.ht.service.MessageService;
import com.ht.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class MessageAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private TUser user;
	private UserService userService;
	private TMessage message;
	private List<TMessage> messagelist;
	private MessageService messageService;
	public TUser getUser() {
		return user;
	}
	public void setUser(TUser user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public TMessage getMessage() {
		return message;
	}
	public void setMessage(TMessage message) {
		this.message = message;
	}
	public List<TMessage> getMessagelist() {
		return messagelist;
	}
	public void setMessagelist(List<TMessage> messagelist) {
		this.messagelist = messagelist;
	}
	public MessageService getMessageService() {
		return messageService;
	}
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	public String pagemessage() throws Exception{
		
		return "pagemessage";
	}
//	public void paginglist() throws Exception {
//		PagingBean page = new PagingBean();
//		//总记录条数，计算总页数
//		page.setPagebarsize(4);
//		page.setPagebarsum(messageService.count("jxsidString",tagency.getIdString()));
//		//当前页
//		String currentpage = request.getParameter("currentpage");
//		//操作
//		String handle = request.getParameter("handle");
//		if(currentpage==null || currentpage.equals("")){
//			//当前页为第一页
//			page.setCurrentpage(1);
//		}else {
//			page.setCurrentpage(Integer.parseInt(currentpage));
//		}
//		if(handle==null || handle.equals("")){
//			if(currentpage==null || currentpage.equals("")){
//				//当前页为第一页
//				page.setCurrentpage(1);
//			}else{	//当前页为第一页
//				page.setCurrentpage(Integer.parseInt(currentpage));
//			}
//			//当前页的操作
//		}else {
//			page.setHandle(handle);
//		}
//		if(page.getPagebarsum()==0){
//			page.setCurrentpage(0);
//			page.setStarlocal(0);
//			page.setPagebarsize(0);
//		}
//		if((page.getStarlocal()+page.getPagebarsize())>=page.getPagebarsum()){
//			DetachedCriteria dc = DetachedCriteria.forClass(TBuilding.class);
//			dc.add(Restrictions.eq("jxsidString", tagency.getIdString()));
//			loudonglist = louDongService.pagelist(dc,(page.getPagebarsum()-page.getPagebarsize()), page.getPagebarsize());
//			page.setStarlocal(page.getPagebarsum()-page.getPagebarsize());
//			request.setAttribute("pager", page);
//			return;
//		}else{
//			DetachedCriteria dc = DetachedCriteria.forClass(TBuilding.class);
//			dc.add(Restrictions.eq("jxsidString", tagency.getIdString()));
//			loudonglist = louDongService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
//			request.setAttribute("pager", page);
//		}
//
//	}
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
}
