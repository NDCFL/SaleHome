package com.ht.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ht.pojo.FileUpInfoVo;
import com.ht.pojo.PagingBean;
import com.ht.pojo.TAgency;
import com.ht.pojo.TCustomer;
import com.ht.pojo.TEmployee;
import com.ht.pojo.TUser;
import com.ht.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TCustomer customer;
	private List<TCustomer> customerlist;
	private CustomerService customerService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private TEmployee employee;
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public FileUpInfoVo getFileUpInfoVo() {
		return fileUpInfoVo;
	}
	public void setFileUpInfoVo(FileUpInfoVo fileUpInfoVo) {
		this.fileUpInfoVo = fileUpInfoVo;
	}
	private String id;
	private File file;
	private String fileFileName;
	private FileUpInfoVo fileUpInfoVo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TCustomer getCustomer() {
		return customer;
	}
	public void setCustomer(TCustomer customer) {
		this.customer = customer;
	}
	public List<TCustomer> getCustomerlist() {
		return customerlist;
	}
	public void setCustomerlist(List<TCustomer> customerlist) {
		this.customerlist = customerlist;
	}
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	public TEmployee getEmployee() {
		return employee;
	}
	public void setEmployee(TEmployee employee) {
		this.employee = employee;
	}
	public String pagecustomer() throws Exception{
		paginglist();
		return "pagecustomer";
	}
	public String addcustomer() throws Exception{
		HttpSession session = request.getSession();
		TEmployee t = (TEmployee)session.getAttribute("employee");
		String filepath = request.getRealPath("/")+"upfile";
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		if(fileFileName==null){
			customer.setHeadiconString("images/people.gif");
		}else{
			String newname = getFileName(fileFileName);
			customer.setHeadiconString("upfile/"+newname);
			FileUtils.copyFile(file, new File(filepath,newname));
		}
		customer.setEmployeeId(t.getIdString());
		customer.setJxsidString(t.getAngencyIdString());
		customer.setCreatedTime(new Date());
		customer.setStatusInt(0);
		customerService.add(customer);
		paginglist();
		return "addcustomer";
	}
	public String updatecustomerstatus(){
		customerService.update(customer);
		return "updatecustomerstatus";
	}
	public String deletecustomer() throws Exception{
		customerService.delete(customer);
		paginglist();
		return "deletecustomer";
	}
	public String deletemanycustomer() throws Exception{
		String idstring[]= id.split(",");
		for(int i=0;i<idstring.length;i++){
			customer = new TCustomer();
			customer.setIdString(idstring[i]);
			customerService.delete(customer);
		}
		paginglist();
		return "deletemanycustomer";
	}
	public String showcustomer() throws Exception{
		customer = customerService.queryById(customer.getIdString());
		return "showcustomer";
	}
	public String pagejxscustomer() throws Exception{
		pagingjxslist();
		return "pagejxscustomer";
	}
	public String updatecustomer() throws Exception{
		String filepath =request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		String newname = getFileName(fileFileName);
		FileUtils.copyFile(file, new File(filepath,newname));
		customer.setContractString(newname);
		customerService.buyhouse(customer);
		paginglist();
		return "updatecustomer";
	}
	public String mybuyhouse() throws Exception{
		paginguserlist();
		return "mybuyhouse";
	}
	public void paginglist() throws Exception {
		HttpSession session = request.getSession();
		TEmployee e = (TEmployee)session.getAttribute("employee");
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(10);
		page.setPagebarsum(customerService.count("employeeId", e.getIdString()));
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
		DetachedCriteria dc = DetachedCriteria.forClass(TCustomer.class);
		dc.add(Restrictions.eq("employeeId", e.getIdString()));
		customerlist = customerService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
		request.setAttribute("pager", page);
	}
	public void pagingjxslist() throws Exception {
		HttpSession session = request.getSession();
		TAgency e = (TAgency)session.getAttribute("tagency");
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(10);
		page.setPagebarsum(customerService.count("jxsidString", e.getIdString()));
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
			page.setHandle("firstpage");
			//当前页的操作
		}else {
			page.setHandle(handle);
		}
		if(page.getPagebarsum()==0){
			page.setCurrentpage(0);
			page.setStarlocal(0);
			page.setPagebarsize(0);
		}
		DetachedCriteria dc = DetachedCriteria.forClass(TCustomer.class);
		dc.add(Restrictions.eq("jxsidString", e.getIdString()));
		customerlist = customerService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
		request.setAttribute("pager", page);
	}
	public void paginguserlist() throws Exception {
		HttpSession session = request.getSession();
		TUser e = (TUser)session.getAttribute("user");
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(3);
		page.setPagebarsum(customerService.count("phoneString", e.getPhoneString()));
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
			page.setHandle("firstpage");
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
			DetachedCriteria dc = DetachedCriteria.forClass(TCustomer.class);
			dc.add(Restrictions.eq("phoneString", e.getPhoneString()));
			dc.add(Restrictions.eq("customerTypeInt", 2));
			customerlist = customerService.pagelist(dc,(page.getPagebarsum()-page.getPagebarsize()), page.getPagebarsize());
			if((page.getPagebarsum()-page.getPagebarsize())<0){
				page.setStarlocal(0);
			}else{
				page.setStarlocal(page.getPagebarsum()-page.getPagebarsize());
			}
			request.setAttribute("pager", page);
			return;
		}else{
			DetachedCriteria dc = DetachedCriteria.forClass(TCustomer.class);
			dc.add(Restrictions.eq("phoneString", e.getPhoneString()));
			customerlist = customerService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
			request.setAttribute("pager", page);
		}
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}
	private synchronized String getFileName(String filename) {
		int position = filename.lastIndexOf(".");
		String ext = filename.substring(position);
		return System.nanoTime() + ext;
	}

	
	
}