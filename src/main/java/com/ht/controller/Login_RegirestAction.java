package com.ht.controller;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.alibaba.fastjson.JSON;
import com.ht.API.HttpClientUtil;
import com.ht.pluspassword.AesUtils;
import com.ht.pojo.TActivity;
import com.ht.pojo.TAgency;
import com.ht.pojo.TArticle;
import com.ht.pojo.TBuildings;
import com.ht.pojo.TPhoneCode;
import com.ht.pojo.TUser;
import com.ht.service.ActivityService;
import com.ht.service.ArticleService;
import com.ht.service.LoginRegisterService;
import com.ht.service.LouPanService;
import com.ht.service.PhoneCodeService;
import com.ht.service.TAgencyService;
import com.ht.service.UserService;
import com.opensymphony.xwork2.ActionSupport;


public class Login_RegirestAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
		
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(Login_RegirestAction.class);
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String useraccount;
	private String password;
	private LoginRegisterService loginRegisterService;
	private TUser user;
	private String registeraccount;
	private static int code;
	private int registercode;
	private String loginpassword;
	private TAgency tagency;
	private TAgencyService tAgencyService;
	private List<TArticle> articlelist;
	private ArticleService  articleService;
	private List<TBuildings> loupanlist;
	private TBuildings loupan;
	private LouPanService louPanService;
	private UserService userService;
	private PhoneCodeService phoneCodeService;
	private ActivityService activityService;
	private List<TActivity> activitylist;
	public ActivityService getActivityService() {
		return activityService;
	}
	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}
	public List<TActivity> getActivitylist() {
		return activitylist;
	}
	public void setActivitylist(List<TActivity> activitylist) {
		this.activitylist = activitylist;
	}
	public PhoneCodeService getPhoneCodeService() {
		return phoneCodeService;
	}
	public void setPhoneCodeService(PhoneCodeService phoneCodeService) {
		this.phoneCodeService = phoneCodeService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public LouPanService getLouPanService() {
		return louPanService;
	}
	public void setLouPanService(LouPanService louPanService) {
		this.louPanService = louPanService;
	}
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
	public List<TBuildings> getLoupanlist() {
		return loupanlist;
	}
	public void setLoupanlist(List<TBuildings> loupanlist) {
		this.loupanlist = loupanlist;
	}
	public TBuildings getLoupan() {
		return loupan;
	}
	public void setLoupan(TBuildings loupan) {
		this.loupan = loupan;
	}
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
	public void setLoginpassword(String loginpassword) {
		this.loginpassword = loginpassword;
	}
	public void setRegistercode(int registercode) {
		this.registercode = registercode;
	}
	public void setRegisteraccount(String registeraccount) {
		this.registeraccount = registeraccount;
	}
	public void setLoginRegisterService(LoginRegisterService loginRegisterService) {
		this.loginRegisterService = loginRegisterService;
	}
	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public TUser getUser() {
		return user;
	}
	public void setUser(TUser user) {
		this.user = user;
	}
	public LoginRegisterService getLoginRegisterService() {
		return loginRegisterService;
	}
 	public String gotoregirest() throws Exception{
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在执行注册方法，当前时间为："+new Date().toLocaleString());
		return "gotoregirest";
	}
 	public String checkuseraccount() throws Exception{
 		PrintWriter out = response.getWriter();
 		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在登录系统，当前时间为："+new Date().toLocaleString());
 		Map<String, Boolean> result = new HashMap<String, Boolean>();
		List<TUser> list  = loginRegisterService.findaccount(useraccount);
		if(list.size()==0){
			result.put("valid", false);
		}else{
			result.put("valid", true);
		}
		out.print(JSON.toJSON(result));
		return null;
	}
	public String checkregisteraccount() throws Exception{
 		PrintWriter out = response.getWriter();
 		Map<String, Boolean> result = new HashMap<String, Boolean>();
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在入驻平台系统，当前时间为："+new Date().toLocaleString());
		List<TUser> list  = loginRegisterService.findaccount(registeraccount);
		if(list.size()!=0){
			result.put("valid", false);
		}else{
			result.put("valid", true);
		}
		out.print(JSON.toJSON(result));
		return null;
	}
 	public String checkpassword() throws Exception{
 		PrintWriter out = response.getWriter();
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在登录系统，当前时间为："+new Date().toLocaleString());
		List<TUser> list =  loginRegisterService.findaccount(useraccount);
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		for(int i=0;i<list.size();i++){
			user = list.get(i);
			if(!user.getPwdString().equals(AesUtils.encryptStr(password, AesUtils.SECRETKEY))){
				System.out.println("原始密码："+user.getPwdString()+";前台密码："+AesUtils.encryptStr(password, AesUtils.SECRETKEY));
				result.put("valid", false);
			}else{
				result.put("valid", true);
			}
		}
		out.print(JSON.toJSON(result));
		return null;
	} 
 	public String loginsuccess() throws Exception{
 		HttpSession session = request.getSession();
 		List<TUser> list =  loginRegisterService.findaccount(useraccount);
 		user = list.get(0);
 		session.setAttribute("user", user);
 		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在登录系统，当前时间为："+new Date().toLocaleString());
 		articlelist = articleService.facetaricle();
		DetachedCriteria dc = DetachedCriteria.forClass(TBuildings.class);
		dc.add(Restrictions.eq("statusInt", 0));
		loupanlist = louPanService.pagelist(dc, 0, 10);
		DetachedCriteria dc1 = DetachedCriteria.forClass(TActivity.class);
		dc1.add(Restrictions.eq("statusInt", 0));
		dc1.addOrder(Order.desc("startTime"));
		activitylist = activityService.pagelist(dc1, 0, 2);
		return "main";
 	}
 	public String exit() throws Exception{
 		HttpSession session = request.getSession();
 		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在退出登录，当前时间为："+new Date().toLocaleString());
 		session.invalidate();
 		articlelist = articleService.facetaricle();
		DetachedCriteria dc = DetachedCriteria.forClass(TBuildings.class);
		dc.add(Restrictions.eq("statusInt", 1));
		loupanlist = louPanService.pagelist(dc, 0, 10);
 		return "exit";
 	}
 	public String jxsmainface() throws Exception{
 		HttpSession session = request.getSession();
 		TUser t = (TUser)session.getAttribute("user");
 		List<TAgency> list =  tAgencyService.tagencylist("phoneString", t.getPhoneString());
 		tagency = list.get(0);
 		session.setAttribute("tagency", tagency);
 		logger.info("Ip为："+request.getRemoteAddr()+"的用户登录成功由首页进入到经销商的首页面，当前时间为："+new Date().toLocaleString());
 		return "jxsmainface";
 	}
 	public String usermainface() throws Exception{
 		logger.info("Ip为："+request.getRemoteAddr()+"的用户登录成功由首页进入到用户的首页面，当前时间为："+new Date().toLocaleString());
 		return "usermainface";
 	}
 	public String jxsregister() throws Exception{
 		HttpSession session = request.getSession();
 		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在注册经销商账户，当前时间为："+new Date().toLocaleString());
 		user = new TUser();
		user.setPhoneString(registeraccount);
		user.setPwdString(AesUtils.encryptStr(loginpassword, AesUtils.SECRETKEY));
		user.setCreateTime(new Date());
		user.setHeadiconString("images/people.gif");
		user.setStatusInt(4);
		user.setReasonString("成功注册成为用户");
		user.setUsertypeInt(0);
		user.setGenderString("男");
		loginRegisterService.add(user);
		List<TUser> list =  loginRegisterService.findaccount(registeraccount);
 		session.setAttribute("user", list.get(0));
 		TUser t = (TUser)session.getAttribute("user");
 		response.sendRedirect(request.getContextPath()+"/index.jsp");
 		return null;
 	}
 	public String regssendcode() throws Exception{
 		response.setContentType("text/html;charset=utf-8");
 		PrintWriter out = response.getWriter();
    	String Uid = "絮落锦乡";
 		String Key = "7dc6e6e7cf7ca510a6a4";
 		int num = new Random().nextInt(899999)+100000;
 		code=num;
 		System.out.println("验证码："+code);
 		String smsText = "【桃源盛景】欢迎入驻桃源盛景:你的验证码为:"+num+"。10分钟之内有效";
 		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在注册经销商账户,发送手机验证码，当前时间为："+new Date().toLocaleString());
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
 	public String sendcode() throws Exception{
 		response.setContentType("text/html;charset=utf-8");
 		PrintWriter out = response.getWriter();
	    Calendar cal = Calendar.getInstance();
        int day=cal.get(Calendar.DATE);
        int number =0;
        try {
        	number = phoneCodeService.count(day+"", request.getRemoteAddr());
		} catch (Exception e) {
			e.printStackTrace();
			number=0;
		}
        if(number>2){
        	out.print(JSON.toJSON("你操作频繁，请明天在试！"));
        	return null;
        }else{
        	String Uid = "絮落锦乡";
     		String Key = "7dc6e6e7cf7ca510a6a4";
     		int num = new Random().nextInt(899999)+100000;
     		code=num;
     		TPhoneCode t = new TPhoneCode();
     		t.setPhoneString(request.getRemoteAddr());
     		t.setPhoneCode(num);
     		t.setSendTime(new Date());
     		phoneCodeService.add(t);
//     		out.print(code);
     		System.out.println("验证码："+code);
     		String smsText = "【桃源盛景】检测到你正在修改你的密码:你的验证码是:"+num+",如果不是本人操作,请修改你的密码,10分钟之内有效";
     		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在修改密码,发送手机验证码，当前时间为："+new Date().toLocaleString());
     		HttpClientUtil client = HttpClientUtil.getInstance();
    		//UTF发送，测试成功，在开发阶段不会启用，当答辩前一天左右开启
    		int result = client.sendMsgUtf8(Uid, Key, smsText, useraccount);
    		if(result>0){
    			System.out.println("经销商"+useraccount+"成功接收"+result+"条短信");
    		}else{
    			System.out.println(client.getErrorMsg(result));
    		}
     		return null;
        }
 	}
 	public String findpwd() throws Exception{
 		List<TUser> list = userService.finduser("phoneString", useraccount);
 		if(list.size()==0){
 		}else{
 			user = list.get(0);
 		}
 		//普通用户
 		if(user.getUsertypeInt()==0){
 			user.setPwdString(AesUtils.encryptStr(loginpassword, AesUtils.SECRETKEY));
 			userService.updateuserpwd(user);
 		}else{
 			List<TAgency> list2 = tAgencyService.tagencylist("useridString", user.getIdString());
 			if(list.size()==0){
 			}else{
 				tagency = tAgencyService.tagencylist("useridString", user.getIdString()).get(0);
 				tagency.setPwdString(AesUtils.encryptStr(loginpassword, AesUtils.SECRETKEY));
 				tAgencyService.updatetagency(tagency);
 				user.setPwdString(AesUtils.encryptStr(loginpassword, AesUtils.SECRETKEY));
 	 			userService.updateuserpwd(user);
 			}
 		}
 		return "findpwd";
 	}
 	public String getLoginpassword() {
		return loginpassword;
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
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
	} 

}
