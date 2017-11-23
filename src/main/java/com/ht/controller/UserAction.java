package com.ht.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.criterion.DetachedCriteria;

import com.alibaba.fastjson.JSON;
import com.ht.pluspassword.AesUtils;
import com.ht.pojo.PagingBean;
import com.ht.pojo.TAgency;
import com.ht.pojo.TUser;
import com.ht.service.TAgencyService;
import com.ht.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import sun.tools.jar.resources.jar;

public class UserAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private UserService userService;
	private TUser user;
	private List<TUser> userlist;
	private String id;
	private Logger logger = Logger.getLogger(LouPanAction.class);
	private File file;
	private String fileFileName;
	private String newpassword;
	private TAgency tagency;
	private TAgencyService tAgencyService;
	public TAgencyService gettAgencyService() {
		return tAgencyService;
	}

	public void settAgencyService(TAgencyService tAgencyService) {
		this.tAgencyService = tAgencyService;
	}

	public TAgency getTagency() {
		return tagency;
	}

	public void setTagency(TAgency tagency) {
		this.tagency = tagency;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

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

	public List<TUser> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<TUser> userlist) {
		this.userlist = userlist;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String pageuser() throws Exception{
		paginglist();
		return "pageuser";
	}
	public String deleteuser() throws Exception{
		user.setIdString(user.getIdString());
		userService.delete(user);
		return "deleteuser";
		
	}
	public String showuser() throws Exception{
		user = userService.queryById(user.getIdString());
		return "showuser";
	}
	public String saveuserinfo() throws Exception{
		HttpSession session = request.getSession();
		String filepath = request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		if(fileFileName==null){
			user.setHeadiconString("images/people.gif");
			userService.updateuserinfo(user);
			paginglist();
			session.setAttribute("user", userService.queryById(user.getIdString()));
			return "saveuserinfo";
		}else{
			String newname = getFileName(fileFileName);
			user.setHeadiconString("upfile/"+newname);
			FileUtils.copyFile(file, new File(filepath,newname));
			userService.updateuserinfo(user);
			paginglist();
			session.setAttribute("user", userService.queryById(user.getIdString()));
			return "saveuserinfo";
		}
		
	}
	public String adduser() throws Exception{
		String filepath = request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		if(fileFileName==null){
			user.setHeadiconString("images/people.gif");
			userService.add(user);
			paginglist();
			return "adduser";
		}else{
			String newname = getFileName(fileFileName);
			user.setHeadiconString("upfile/"+newname);
			FileUtils.copyFile(file, new File(filepath,newname));
			userService.add(user);
			paginglist();
			return "adduser";
		}
		
	}
	public String deletemanyuser() throws Exception{
		String idstring[]= id.split(",");
		for(int i=0;i<idstring.length;i++){
			user = new TUser();
			user.setIdString(idstring[i]);
			logger.info("Ip为："+request.getRemoteAddr()+"的用户正在删除多个客户,客户"+i+"编号为"+idstring[i]+"，当前时间为："+new Date().toLocaleString());
			userService.delete(user);
		}
		paginglist();
		return "deletemanyuser";
		
	}
	public String updateuser() throws Exception{
		user = userService.queryById(user.getIdString());
		return "updateuser";
	}
	public String initpwd() throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		TUser t = (TUser)session.getAttribute("user");
		user = userService.queryById(t.getIdString());
		out.print(AesUtils.decryptStr(user.getPwdString(), AesUtils.SECRETKEY));
		return null;
	}
	public String updateuserpwd() throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		TUser t = (TUser)session.getAttribute("user");
		user = new TUser();
		user.setIdString(t.getIdString());
		user.setPwdString(AesUtils.encryptStr(newpassword, AesUtils.SECRETKEY));
		userService.updateuserpwd(user);
		out.print(JSON.toJSON("修改成功"));
		return null;
	}
	public String updatesaveuser() throws Exception{ 
		HttpSession session = request.getSession();
		String filepath = request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		if(fileFileName==null){
			user.setHeadiconString(user.getHeadiconString());
			userService.add(user);
			paginglist();
			session.setAttribute("user", userService.queryById(user.getIdString()));
			return "updatesaveuser";
		}else{
			String newname = getFileName(fileFileName);
			user.setHeadiconString("upfile/"+newname);
			FileUtils.copyFile(file, new File(filepath,newname));
			userService.add(user);
			paginglist();
			session.setAttribute("user", userService.queryById(user.getIdString()));
			return "updatesaveuser";
		}
	}
	public String shenqingjxs() throws Exception{
		HttpSession session = request.getSession();
		TUser t = (TUser)session.getAttribute("user");
		List<TAgency> list= tAgencyService.tagencylist("useridString", t.getIdString());
		if(list.size()!=0){
			tagency = new TAgency();
			tagency = list.get(0);
			return "ruzhu";
		}else{
			return "shenqingjxs";
		}
	}
	public  String ruzhu() throws Exception{
		HttpSession session = request.getSession();
		TUser t = (TUser)session.getAttribute("user");
		List<TAgency> li = tAgencyService.tagencylist("useridString", t.getIdString());
		if(li.size()!=0){
			TAgency ta= li.get(0);
			tAgencyService.delete(ta);
		}else{
			
		}
		String filepath = request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		String newname = "";
		try {
			newname = getFileName(fileFileName);
			FileUtils.copyFile(file, new File(filepath,newname));
		} catch (Exception e) {
			newname="people.gif";
		}
		tagency.setLogoString("upfile/"+newname);
		tagency.setAddressString(tagency.getAddressString());
		tagency.setEmailString(t.getEmailString());
		tagency.setPhoneString(t.getPhoneString());
		tagency.setPwdString(t.getPwdString());
		tagency.setCreatedTime(new Date());
		tagency.setCheckedStatusInt(0);
		tagency.setStatusInt(0);
		tagency.setReasonString("请求审核");
		tagency.setUseridString(t.getIdString());
		tAgencyService.add(tagency);
		List<TAgency> list= tAgencyService.tagencylist("useridString", t.getIdString());
		tagency = new TAgency();
		tagency = list.get(0);
		return "ruzhu";
		
	}
	
	public void paginglist() throws Exception {
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(10);
		page.setPagebarsum(userService.finduser().size());
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
		DetachedCriteria dc = DetachedCriteria.forClass(TUser.class);
		userlist = userService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
		request.setAttribute("pager", page);
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}
	private synchronized String getFileName(String filename) {
		int position = filename.lastIndexOf(".");
		String ext = filename.substring(position);
		return System.nanoTime() + ext;
	}

}
