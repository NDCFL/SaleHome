package com.ht.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.ht.pojo.PagingBean;
import com.ht.pojo.TComment;
import com.ht.pojo.TCustomer;
import com.ht.pojo.TEmployee;
import com.ht.pojo.TUser;
import com.ht.service.CommentService;
import com.ht.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;

public class CommentAction extends ActionSupport implements ServletResponseAware,ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CommentService commentService;
	private List<TComment> commentlist;
	private TComment comment;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private CustomerService customerService;
	private List<TCustomer> customerlist;
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	public List<TCustomer> getCustomerlist() {
		return customerlist;
	}
	public void setCustomerlist(List<TCustomer> customerlist) {
		this.customerlist = customerlist;
	}
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	public List<TComment> getCommentlist() {
		return commentlist;
	}
	public void setCommentlist(List<TComment> commentlist) {
		this.commentlist = commentlist;
	}
	public TComment getComment() {
		return comment;
	}
	public void setComment(TComment comment) {
		this.comment = comment;
	}
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String pagecomment() throws Exception{
		paginglist();
		return "pagecomment";
	}
	public String updatecommentstatus() throws Exception{
		try {
			commentService.update(comment);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		paginglist();
		return "updatecommentstatus";
	}
	public String deletemanycomment() throws Exception{
		String idstring[]= id.split(",");
		for(int i=0;i<idstring.length;i++){
			comment = new TComment();
			comment.setIdString(idstring[i]);
			commentService.delete(comment);
		}
		paginglist();
		return "deletemanyemployee";
	}
	public String deletecomment() throws Exception{
		commentService.delete(comment);
		paginglist();
		return "deletecomment";
	}
	public void paginglist() throws Exception {
		HttpSession session = request.getSession();
		TUser t = (TUser)session.getAttribute("user");
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(10);
		page.setPagebarsum(commentService.count("userIdString",t.getIdString()));
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
		DetachedCriteria dc = DetachedCriteria.forClass(TComment.class);
		dc.addOrder(Order.desc("commentTime"));
		dc.add(Restrictions.eq("userIdString",t.getIdString()));
		commentlist = commentService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
		request.setAttribute("pager", page);
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
