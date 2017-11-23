package com.ht.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.alibaba.fastjson.JSON;
import com.ht.API.HttpClientUtil;
import com.ht.API.SendEmail;
import com.ht.pluspassword.AesUtils;
import com.ht.pojo.PagingBean;
import com.ht.pojo.TAgency;
import com.ht.pojo.TBuildings;
import com.ht.pojo.TEmployee;
import com.ht.service.EmployeeService;
import com.ht.service.LouPanService;
import com.opensymphony.xwork2.ActionSupport;


public class EmployeeAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private TEmployee employee;
	private List<TEmployee> employeelist;
	private EmployeeService employeeService; 
	private String password;
	private File file;
	private String fileFileName;
	private String registeraccount;
	private String loginpassword;
	private static int code;
	private int registercode;
	private String newpassword;
	private String employeeaccount;
	private List<TBuildings> loupanlist;
	private LouPanService louPanService;
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LouPanService getLouPanService() {
		return louPanService;
	}
	public void setLouPanService(LouPanService louPanService) {
		this.louPanService = louPanService;
	}
	public List<TBuildings> getLoupanlist() {
		return loupanlist;
	}
	public void setLoupanlist(List<TBuildings> loupanlist) {
		this.loupanlist = loupanlist;
	}
	public String getUseraccount() {
		return employeeaccount;
	}
	public void setUseraccount(String employeeaccount) {
		this.employeeaccount = employeeaccount;
	}
	private Logger logger = Logger.getLogger(Login_RegirestAction.class);

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getRegisteraccount() {
		return registeraccount;
	}
	public void setRegisteraccount(String registeraccount) {
		this.registeraccount = registeraccount;
	}
	public String getLoginpassword() {
		return loginpassword;
	}
	public void setLoginpassword(String loginpassword) {
		this.loginpassword = loginpassword;
	}
	public static int getCode() {
		return code;
	}
	public static void setCode(int code) {
		EmployeeAction.code = code;
	}
	public int getRegistercode() {
		return registercode;
	}
	public void setRegistercode(int registercode) {
		this.registercode = registercode;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public TEmployee getEmployee() {
		return employee;
	}
	public void setEmployee(TEmployee employee) {
		this.employee = employee;
	}
	public List<TEmployee> getEmployeelist() {
		return employeelist;
	}
	public void setEmployeelist(List<TEmployee> employeelist) {
		this.employeelist = employeelist;
	}
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public String checkemployeeaccount() throws Exception {
		PrintWriter out = response.getWriter();
		logger.info("Ip为：" + request.getRemoteAddr() + "的用户正在登录系统，当前时间为：" + new Date().toLocaleString());
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		List<TEmployee> list = employeeService.empList("phoneString",employeeaccount);
		if (list.size() == 0) {
			result.put("valid", false);
		} else {
			result.put("valid", true);
		}
		out.print(JSON.toJSON(result));
		return null;
	}
	public String checkregisteraccount() throws Exception {
		PrintWriter out = response.getWriter();
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		logger.info("Ip为：" + request.getRemoteAddr() + "的用户正在入驻平台系统，当前时间为：" + new Date().toLocaleString());
		List<TEmployee> list = employeeService.empList("phoneString",registeraccount);
		if (list.size() != 0) {
			result.put("valid", false);
		} else {
			result.put("valid", true);
		}
		out.print(JSON.toJSON(result));
		return null;
	}	
	public  String deleteemployee() throws Exception{
		employeeService.delete(employee);
		paginglist();
		return "deleteemployee";
	} 
	public String deletemanyemployee() throws Exception{
		String idstring[]= id.split(",");
		for(int i=0;i<idstring.length;i++){
			employee = new TEmployee();
			employee.setIdString(idstring[i]);
			logger.info("Ip为："+request.getRemoteAddr()+"的用户正在删除多个楼盘,楼盘"+i+"编号为"+idstring[i]+"，当前时间为："+new Date().toLocaleString());
			employeeService.delete(employee);
		}
		paginglist();
		return "deletemanyemployee";
	}
	public String checkpassword() throws Exception {
		PrintWriter out = response.getWriter();
		logger.info("Ip为：" + request.getRemoteAddr() + "的用户正在登录系统，当前时间为：" + new Date().toLocaleString());
		List<TEmployee> list = employeeService.empList("phoneString",employeeaccount);
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		for (int i = 0; i < list.size(); i++) {
			employee = list.get(i);
			if (!employee.getPwdString().equals(AesUtils.encryptStr(password, AesUtils.SECRETKEY))) {
				System.out.println(
						"原始密码：" + employee.getPwdString() + ";前台密码：" + AesUtils.encryptStr(password, AesUtils.SECRETKEY));
				result.put("valid", false);
			} else {
				result.put("valid", true);
			}
		}
		out.print(JSON.toJSON(result));
		return null;
	}

	public String loginsuccess() throws Exception {
		HttpSession session = request.getSession();
		List<TEmployee> list = employeeService.empList("phoneString",employeeaccount);
		employee = list.get(0);
		session.setAttribute("employee", employee);
		logger.info("Ip为：" + request.getRemoteAddr() + "的员工正在登录系统，当前时间为：" + new Date().toLocaleString());
		response.sendRedirect(request.getContextPath() + "/hui-jxs/employeeindex.jsp");
		return null;
	}
	public String showemployee() throws Exception{
		employee = employeeService.queryById(employee.getIdString());
		return "showemployee";
		
	}
	public String exit() throws Exception {
		HttpSession session = request.getSession();
		logger.info("Ip为：" + request.getRemoteAddr() + "的用户正在退出登录，当前时间为：" + new Date().toLocaleString());
		session.invalidate();
		return "exit";
	}

	public String employeemainface() throws Exception {
		List<TEmployee> list = employeeService.empList("phoneString", employeeaccount);
		employee = list.get(0);
		logger.info("Ip为：" + request.getRemoteAddr() + "的用户登录成功由首页进入到经销商的首页面，当前时间为：" + new Date().toLocaleString());
		return "employeemainface";
	}
	public String employeeregister() throws Exception{
 		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在注册经销商账户，当前时间为："+new Date().toLocaleString());
		employeeService.add(employee);
 		return "employeeregister";
 	}
	public String sendcode() throws Exception{
		response.setContentType("text/html;charset=utf-8");
 		PrintWriter out = response.getWriter();
 		try {
 			//用户名
 	 		String Uid = "絮落锦乡";
 	 		//接口安全秘钥
 	 		String Key = "7dc6e6e7cf7ca510a6a4";
 	 		int num = new Random().nextInt(899999)+100000;
 	 		code=num;
 	 		List<TEmployee> list = employeeService.empList("phoneString", employeeaccount);
 	 		if(list.size()==0){
 	 		}else{
 	 			employee = list.get(0);
 	 		}
 	 		employee.setPwdString(AesUtils.encryptStr(num+"", AesUtils.SECRETKEY));
 	 		employeeService.update(employee);
 	 		out.print(JSON.toJSON("密码修改成功，新密码已发送至你的手机，请查收。"));
 	 		System.out.println(code);
 	 		//短信内容
 	 		String smsText = "【桃源盛景】检测到你正在修改你的登录密码:你的新密码为:"+num+"。请妥善保管，如不是本人操作，请修改你的密码。";
 	 		logger.info("Ip为："+request.getRemoteAddr()+"员工正在修改密码,发送手机验证码，当前时间为："+new Date().toLocaleString());
 	 		HttpClientUtil client = HttpClientUtil.getInstance();
 			//UTF发送，测试成功，在开发阶段不会启用，当答辩前一天左右开启
 			int result = client.sendMsgUtf8(Uid, Key, smsText, employeeaccount);
 			if(result>0){
 				System.out.println("经销商"+employeeaccount+"成功接收"+result+"条短信");
 			}else{
 				System.out.println(client.getErrorMsg(result));
 			}
		} catch (Exception e) {
			out.print(JSON.toJSON("密码修改失败"));
		}
 		return null;
 	}
 	public String checkcode() throws Exception{
 		PrintWriter out = response.getWriter();
 		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在注册经销商账户,核对验证码，当前时间为："+new Date().toLocaleString());
 		Map<String, Boolean> result = new HashMap<String, Boolean>();
 		if(registercode!=code){
			result.put("valid", false);
 		}else{
 			result.put("valid", true);
 		}
 		out.print(JSON.toJSON(result));
 		return null;
 	}
 	public String updatesaveemployee() throws Exception{
 		String filepath = request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		if(fileFileName==null){
			employee.setHeadiconString("images/people.gif");
			employeeService.update(employee);
			employee = employeeService.queryById(employee.getIdString());
			return "updatesaveemployee";
		}else{
			String newname = getFileName(fileFileName);
			employee.setHeadiconString("upfile/"+newname);
			FileUtils.copyFile(file, new File(filepath,newname));
			employeeService.update(employee);
			employee = employeeService.queryById(employee.getIdString());
			return "updatesaveemployee";
		}
 	}
 	public String initpwd() throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		TEmployee t = (TEmployee)session.getAttribute("employee");
		employee = employeeService.queryById(t.getIdString());
		out.print(AesUtils.decryptStr(employee.getPwdString(),AesUtils.SECRETKEY));
		return null;
	}
 	public String initupdateemployeeloupan() throws Exception{
 		HttpSession session = request.getSession();
 		TAgency t = (TAgency)session.getAttribute("tagency");
 		employee = employeeService.queryById(employee.getIdString());
 		loupanlist = louPanService.buildingslist("jxsidString", t.getIdString());
 		return "initupdateemployeeloupan";
 	}
 	public String updatesaveemployeeloupan() throws Exception{
 		employeeService.updateemployee(employee);
 		paginglist();
 		return "updatesaveemployeeloupan";
 	}
 	public String initaddemployee() throws Exception{
 		HttpSession session = request.getSession();
 		TAgency t = (TAgency)session.getAttribute("tagency");
 		loupanlist = louPanService.buildingslist("jxsidString", t.getIdString());
 		return "initaddemployee";
 	}
 	public String addemployee() throws Exception{
 		List<TEmployee> list = employeeService.empList("phoneString", employee.getPhoneString());
 		if(list.size()==0){
 			String filepath = request.getRealPath("/")+"upfile"; 
 			File file1 = new File(filepath);
 			HttpSession session = request.getSession();
 	 		TAgency t = (TAgency)session.getAttribute("tagency");
 			if (!file1.exists()) {
 				file1.mkdir();
 			}
 			if(fileFileName==null){
 				employee.setHeadiconString("images/people.gif");
 			}else{
 				String newname = getFileName(fileFileName);
 				employee.setHeadiconString("upfile/"+newname);
 				FileUtils.copyFile(file, new File(filepath,newname));
 			}
 	 		employee.setAngencyIdString(t.getIdString());
 	 		employee.setPwdString(AesUtils.encryptStr(employee.getPhoneString(), AesUtils.SECRETKEY));
 	 		employee.setCreatedTime(new Date());
 	 		employee.setStatusInt(0);
 	 		employeeService.add(employee);
 	 		String receiveEmail = employee.getEmailString();
 	        String receiveNick="陈飞龙";
 	        String subject="【桃源盛景】";
 	        String contents="";
 	        if(employee.getTypeInt()==0){
 	        	contents="【桃源盛景】欢迎你来到本公司就总经理一职,公司已经为你字平台分配了你的账号，以后员工的管理由你负责，你的账号和密码为："+employee.getPhoneString()+",请你在24小时之内登录平台修改密码，网址为：http://192.168.43.14:8888/SaleHome/hui-jxs/employeelogin.jsp";
 	        }else if (employee.getTypeInt()==1) {
 	        	contents="【桃源盛景】欢迎你来到本公司就职,公司已经为你字平台分配了你的账号,你的账号和密码为："+employee.getPhoneString()+",请你在24小时之内登录平台修改密码，网址为：http://192.168.43.14:8888/SaleHome/hui-jxs/employeelogin.jsp";
 			}else if (employee.getTypeInt()==2) {
 	        	contents="【桃源盛景】欢迎你来到本公司的财务部就职,公司已经为你字平台分配了你的账号,你的账号和密码为："+employee.getPhoneString()+",请你在24小时之内登录平台修改密码，网址为：http://192.168.43.14:8888/SaleHome/hui-jxs/employeelogin.jsp";
 			}
 	        SendEmail.sendMail(receiveEmail, receiveNick, subject, contents);
 	 		paginglist();
 	 		return "addemployee";
 		}else{
 			paginglist();
 	 		return "addemployee";
 		}
 	}
	public String updatepwd() throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		TEmployee t = (TEmployee)session.getAttribute("employee");
		employee = new TEmployee();
		employee.setIdString(t.getIdString());
		employee.setPwdString(AesUtils.encryptStr(newpassword, AesUtils.SECRETKEY));
		employeeService.update(employee);
		out.print(JSON.toJSON("修改成功"));
		return null;
	}
	public String updateemployee() throws Exception{
		employee = employeeService.queryById(employee.getIdString());
		return "updateemployee";
	}
	public String saveemployeeinfo() throws Exception{
		String filepath = request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		if(fileFileName==null){
			employee.setHeadiconString("images/people.gif");
			employeeService.updateinfo(employee);
			return "saveemployeeinfo";
		}else{
			String newname = getFileName(fileFileName);
			employee.setHeadiconString("upfile/"+newname);
			FileUtils.copyFile(file, new File(filepath,newname));
			employeeService.updateinfo(employee);
			return "saveemployeeinfo";
		}
	}
	public String updateemployeestatus() throws Exception{
		employeeService.updatestatus(employee);
		return "updateemployeestatus";
	}
	public String pageemployee() throws Exception{
		paginglist();
		return "pageemployee";
	}
	public String findmypwd() throws Exception{
 		PrintWriter out = response.getWriter();
 		//用户名
 		String Uid = "絮落锦乡";
 		//接口安全秘钥
 		String Key = "7dc6e6e7cf7ca510a6a4";
 		int num = new Random().nextInt(899999)+100000;
 		code=num;
 		out.print(code);
 		System.out.println("验证码："+code);
 		//短信内容
 		String smsText = "【桃源盛景】检测到你正在修改你的登录密码:你的新密码为:"+num+"。请妥善保管，如不是本人操作，请修改你的密码。";
 		logger.info("Ip为："+request.getRemoteAddr()+"的员工正在修改密码,发送手机验证码，当前时间为："+new Date().toLocaleString());
 		HttpClientUtil client = HttpClientUtil.getInstance();
		//UTF发送，测试成功，在开发阶段不会启用，当答辩前一天左右开启
		int result = client.sendMsgUtf8(Uid, Key, smsText, registeraccount);
		if(result>0){
			System.out.println("经销商"+registeraccount+"成功接收"+result+"条短信");
		}else{
			System.out.println(client.getErrorMsg(result));
		}
 		return null;
 	}
	public void paginglist() throws Exception {
		HttpSession session = request.getSession();
 		TEmployee t = (TEmployee)session.getAttribute("employee");
 		TAgency tagency = (TAgency)session.getAttribute("tagency");
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(10);
		if(t==null){
			page.setPagebarsum(employeeService.count("angencyIdString",tagency.getIdString()));
		}else{
			page.setPagebarsum(employeeService.count("angencyIdString",t.getAngencyIdString()));
		}
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
		DetachedCriteria dc = DetachedCriteria.forClass(TEmployee.class);
		if(t==null){
			dc.add(Restrictions.eq("angencyIdString",tagency.getIdString()));
		}else{
			dc.add(Restrictions.eq("angencyIdString",t.getAngencyIdString()));
		}
		employeelist = employeeService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
		request.setAttribute("pager", page);
	}
	private synchronized String getFileName(String filename) {
		int position = filename.lastIndexOf(".");
		String ext = filename.substring(position);
		return System.nanoTime() + ext;
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
