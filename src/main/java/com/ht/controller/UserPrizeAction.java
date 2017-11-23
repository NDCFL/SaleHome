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
import com.ht.pojo.TEmployee;
import com.ht.pojo.TUserprize;
import com.ht.service.EmployeeService;
import com.ht.service.UserPrizeService;
import com.opensymphony.xwork2.ActionSupport;

public class UserPrizeAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private TUserprize userPrize;
	private UserPrizeService userPrizeService;
	private List<TUserprize> userprizelist;
	private TEmployee employee;
	private EmployeeService employeeService;
	public TEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(TEmployee employee) {
		this.employee = employee;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	private double mymoney;
	public double getMymoney() {
		return mymoney;
	}

	public void setMymoney(double mymoney) {
		this.mymoney = mymoney;
	}

	public TUserprize getUserPrize() {
		return userPrize;
	}

	public void setUserPrize(TUserprize userPrize) {
		this.userPrize = userPrize;
	}

	public UserPrizeService getUserPrizeService() {
		return userPrizeService;
	}

	public void setUserPrizeService(UserPrizeService userPrizeService) {
		this.userPrizeService = userPrizeService;
	}

	public List<TUserprize> getUserprizelist() {
		return userprizelist;
	}

	public void setUserprizelist(List<TUserprize> userprizelist) {
		this.userprizelist = userprizelist;
	}
	
	public String pageuserprize() throws Exception{
		paginglist();
		return "pageuserprize";
	}
	public String quentitysalary() throws Exception{
		paginglist();
		return "quentitysalary";
	}
	public String mysumsalary() throws Exception{
		HttpSession session = request.getSession();
		TEmployee employee = (TEmployee)session.getAttribute("employee");
		mymoney = userPrizeService.salary(employee.getIdString());
		paginglist();
		return "mysumsalary";
	}
	public void paginglist() throws Exception {
		HttpSession session = request.getSession();
 		TEmployee t = (TEmployee)session.getAttribute("employee");
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(10);
		page.setPagebarsum(userPrizeService.count("employeeidString",t.getIdString()));
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
		DetachedCriteria dc = DetachedCriteria.forClass(TUserprize.class);
		dc.add(Restrictions.eq("employeeidString",t.getIdString()));
		userprizelist = userPrizeService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
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
