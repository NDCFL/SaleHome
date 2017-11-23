package com.ht.controller;

import java.io.File;
import java.io.FileOutputStream;
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
import com.ht.pluspassword.AesUtils;
import com.ht.pojo.FileUpInfoVo;
import com.ht.pojo.PagingBean;
import com.ht.pojo.TArticle;
import com.ht.pojo.TArticleType;
import com.ht.pojo.TBuildings;
import com.ht.pojo.TManager;
import com.ht.service.ArticleService;
import com.ht.service.ManagerService;
import com.ht.service.TArticleTypeService;
import com.opensymphony.xwork2.ActionSupport;

public class ManagerAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private Logger logger = Logger.getLogger(Login_RegirestAction.class);
	private HttpServletResponse response;
	private List<TManager> managerlist;
	private ManagerService managerService;
	private TManager manager;
	private String manageraccount;
	private String password;
	private File file;
	private String fileFileName;
	private String registeraccount;
	private String loginpassword;
	private static int code;
	private int registercode;
	private String newpassword;
	private ArticleService articleService;
	private TArticle article;
	private List<TArticle> tArticleslist;
	private FileUpInfoVo fileupinfo;
	private List<TArticle> articleslist;
	private TArticleTypeService tArticleTypeService;
	private List<TArticleType> typelist;
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public FileUpInfoVo getFileupinfo() {
		return fileupinfo;
	}

	public void setFileupinfo(FileUpInfoVo fileupinfo) {
		this.fileupinfo = fileupinfo;
	}

	public List<TArticle> getArticleslist() {
		return articleslist;
	}

	public void setArticleslist(List<TArticle> articleslist) {
		this.articleslist = articleslist;
	}

	public TArticleTypeService gettArticleTypeService() {
		return tArticleTypeService;
	}

	public void settArticleTypeService(TArticleTypeService tArticleTypeService) {
		this.tArticleTypeService = tArticleTypeService;
	}

	public List<TArticleType> getTypelist() {
		return typelist;
	}

	public void setTypelist(List<TArticleType> typelist) {
		this.typelist = typelist;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public TArticle getArticle() {
		return article;
	}

	public void setArticle(TArticle article) {
		this.article = article;
	}

	public List<TArticle> gettArticleslist() {
		return tArticleslist;
	}

	public void settArticleslist(List<TArticle> tArticleslist) {
		this.tArticleslist = tArticleslist;
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

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	

	public List<TManager> getManagerlist() {
		return managerlist;
	}

	public void setManagerlist(List<TManager> managerlist) {
		this.managerlist = managerlist;
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public TManager getManager() {
		return manager;
	}

	public void setManager(TManager manager) {
		this.manager = manager;
	}

	public String getUseraccount() {
		return manageraccount;
	}

	public void setUseraccount(String manageraccount) {
		this.manageraccount = manageraccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	public String addmanager() throws Exception{
		String filepath = request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		if(fileFileName==null){
			manager.setHeadiconString("images/people.gif");
		}else{
			String newname = getFileName(fileFileName);
			manager.setHeadiconString("upfile/"+newname);
			FileUtils.copyFile(file, new File(filepath,newname));
			manager.setHeadiconString(newname);
			manager.setPasswordString(AesUtils.encryptStr(manager.getPasswordString(), AesUtils.SECRETKEY));
			manager.setStatusInt(0);
			manager.setTypeInt(0);
			manager.setCreateTime(new Date());
			manager.setReasonString("成功注册为管理员");
			manager.setCheckedStatusInt(0);
		}
		managerService.add(manager);
		paginglist();
		return "addmanager";
	}
	public String checkmanageraccount() throws Exception {
		PrintWriter out = response.getWriter();
		logger.info("Ip为：" + request.getRemoteAddr() + "的用户正在登录系统，当前时间为：" + new Date().toLocaleString());
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		List<TManager> list = managerService.findManager("phoneString",manageraccount);
		if (list.size() == 0) {
			result.put("valid", false);
		} else {
			result.put("valid", true);
		}
		out.print(JSON.toJSON(result));
		return null;
	}
	public String deletemanymanager() throws Exception{
		String idstring[]= id.split(",");
		for(int i=0;i<idstring.length;i++){
			manager = new TManager();
			manager.setIdString(idstring[i]);
			managerService.delete(manager);
		}
		paginglist();
		return "deletemanymanager";
	}
	public String deletemanager() throws Exception{
		managerService.delete(manager);
		paginglist();
		return null;
	}
	public String checkregisteraccount() throws Exception {
		PrintWriter out = response.getWriter();
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		logger.info("Ip为：" + request.getRemoteAddr() + "的用户正在入驻平台系统，当前时间为：" + new Date().toLocaleString());
		List<TManager> list = managerService.findManager("phoneString",registeraccount);
		if (list.size() != 0) {
			result.put("valid", false);
		} else {
			result.put("valid", true);
		}
		out.print(JSON.toJSON(result));
		return null;
	}

	public String checkpassword() throws Exception {
		PrintWriter out = response.getWriter();
		logger.info("Ip为：" + request.getRemoteAddr() + "的用户正在登录系统，当前时间为：" + new Date().toLocaleString());
		List<TManager> list = managerService.findManager("phoneString",manageraccount);
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		for (int i = 0; i < list.size(); i++) {
			manager = list.get(i);
			if (!manager.getPasswordString().equals(AesUtils.encryptStr(password, AesUtils.SECRETKEY))) {
				System.out.println(
						"原始密码：" + manager.getPasswordString() + ";前台密码：" + AesUtils.encryptStr(password, AesUtils.SECRETKEY));
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
		List<TManager> list = managerService.findManager("phoneString",manageraccount);
		manager = list.get(0);
		session.setAttribute("manager", manager);
		logger.info("Ip为：" + request.getRemoteAddr() + "的用户正在登录系统，当前时间为：" + new Date().toLocaleString());
		response.sendRedirect(request.getContextPath() + "/hui-jxs/managerindex.jsp");
		return null;
	}
	public String showmanager() throws Exception{
		manager = managerService.queryById(manager.getIdString());
		return "showmanager";
		
	}
	public String exit() throws Exception {
		HttpSession session = request.getSession();
		logger.info("Ip为：" + request.getRemoteAddr() + "的用户正在退出登录，当前时间为：" + new Date().toLocaleString());
		session.invalidate();
		return "exit";
	}

	public String managermainface() throws Exception {
		List<TManager> list = managerService.findManager("phoneString", manageraccount);
		manager = list.get(0);
		logger.info("Ip为：" + request.getRemoteAddr() + "的用户登录成功由首页进入到经销商的首页面，当前时间为：" + new Date().toLocaleString());
		return "jxsmainface";
	}
	public String managerregister() throws Exception{
 		HttpSession session = request.getSession();
 		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在注册经销商账户，当前时间为："+new Date().toLocaleString());
		manager = new TManager();
 		manager.setPhoneString(registeraccount);
		manager.setPasswordString(AesUtils.encryptStr(loginpassword, AesUtils.SECRETKEY));
		manager.setCreateTime(new Date());
		manager.setStatusInt(4);
		manager.setReasonString("注册成为普通用户");
		manager.setSexInt(0);
		manager.setTypeInt(0);
		manager.setNameString("管理员");
		manager.setHeadiconString("images/people.gif");
		manager.setCheckedStatusInt(1);
		managerService.add(manager);
		List<TManager> list =  managerService.findManager("phoneString",registeraccount);
 		session.setAttribute("manager", list.get(0));
 		return "managerregister";
 	}
	public String sendcode() throws Exception{
 		PrintWriter out = response.getWriter();
 		//用户名
 		String Uid = "絮落锦乡";
 		//接口安全秘钥
 		String Key = "7dc6e6e7cf7ca510a6a4";
 		int num = new Random().nextInt(899999)+100000;
 		code=num;
 		List<TManager> list = managerService.findManager("phoneString", manageraccount);
 		if(list.size()==0){
 		}else{
 			manager = list.get(0);
 		}
 		manager.setPasswordString(AesUtils.encryptStr(num+"", AesUtils.SECRETKEY));
 		managerService.updatepwd(manager);
 		out.print(JSON.toJSON("密码修改成功，新密码已发送至你的手机，请查收。"));
 		System.out.println(code);
 		//短信内容
 		String smsText = "【桃源盛景】检测到你正在修改密码:你的新密码为:"+num+"。10分钟之内有效，请妥善保管。";
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
 	
 	public String updatesavemanager() throws Exception{
 		String filepath = request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		if(fileFileName==null){
			manager.setHeadiconString("images/people.gif");
			managerService.updateManager(manager);
			manager = managerService.queryById(manager.getIdString());
			return "updatesavemanager";
		}else{
			String newname = getFileName(fileFileName);
			manager.setHeadiconString("upfile/"+newname);
			FileUtils.copyFile(file, new File(filepath,newname));
			managerService.updateManager(manager);
			manager = managerService.queryById(manager.getIdString());
			return "updatesavemanager";
		}
 	}
 	public String changevip() throws Exception{
 		PrintWriter out = response.getWriter();
 		response.setContentType("text/html;charset=utf-8");
 		manager.setStatusInt(0);
 		manager.setTypeInt(0);
 		manager.setReasonString("请求提交成功，我们会尽快处理！");
 		managerService.update(manager);
 		out.print(JSON.toJSON("申请成功"));
 		return "changevip";
 	}
 	public String vip() throws Exception{
 		manager = managerService.queryById(manager.getIdString());
 		return "vip";
 	}
 	public static int getCode() {
		return code;
	}

	public static void setCode(int code) {
		ManagerAction.code = code;
	}

	public int getRegistercode() {
		return registercode;
	}

	public void setRegistercode(int registercode) {
		this.registercode = registercode;
	}

	public String initpwd() throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		TManager t = (TManager)session.getAttribute("manager");
		manager = managerService.queryById(t.getIdString());
		out.print(AesUtils.decryptStr(manager.getPasswordString(),AesUtils.SECRETKEY));
		return null;
	}
	public String updatemanagerpwd() throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		TManager t = (TManager)session.getAttribute("manager");
		manager = new TManager();
		manager.setIdString(t.getIdString());
		manager.setPasswordString(AesUtils.encryptStr(newpassword, AesUtils.SECRETKEY));
		managerService.updatepwd(manager);
		out.print(JSON.toJSON("修改成功"));
		return null;
	}
	public String updatemanager() throws Exception{
		manager = managerService.queryById(manager.getIdString());
		return "updatemanager";
	}
	public String pagemanager() throws Exception{
		paginglist();
		return "pagemanager";
	}
	public String shenhemanager() throws Exception{
		if(manager.getCheckedStatusInt()==2){
			manager.setCheckedStatusInt(manager.getCheckedStatusInt());
			manager.setTypeInt(1);
		}else{
			manager.setCheckedStatusInt(manager.getCheckedStatusInt());
			manager.setTypeInt(0);
		}
		managerService.update(manager);
		paginglist();
		return "shenhemanager";
	}
	public String updatemanagerstatus() throws Exception{
		managerService.updatestatus(manager);
		return "updatemanagerstatus";
	} 
	
	public void paginglist() throws Exception {
		HttpSession session =request.getSession();
		TManager manager =(TManager)session.getAttribute("manager");
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(10);
		page.setPagebarsum(managerService.count("",""));
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
		DetachedCriteria dc = DetachedCriteria.forClass(TManager.class);
		dc.add(Restrictions.not(Restrictions.eq("idString",manager.getIdString())));
		managerlist = managerService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
		request.setAttribute("pager", page);

	}
	public String upfile() throws Exception{
		HttpSession session = request.getSession();
		TManager manager = (TManager)session.getAttribute("manager");
		String filepath = request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		System.out.println(fileupinfo.getDocFileName());
		String newname = getFileName(fileupinfo.getDocFileName());
		article.setLogoString("upfile/"+newname);
		FileUtils.copyFile(fileupinfo.getDoc(), new File(filepath,newname));
		long filename = System.currentTimeMillis();
		String msgContentUrl="upfile/"+filename+".html";
		uploud(article.getContentString(), msgContentUrl);
		article.setCreatedTime(new Date());
		article.setStatusInt(0);
		article.setContenturlString(msgContentUrl);
		article.setManageridString(manager.getIdString());
		articleService.add(article);
		paginglist1();
		return "upfile";
		
	}
	public String initaddarticle() throws Exception{
		DetachedCriteria dc = DetachedCriteria.forClass(TArticleType.class);
		typelist = tArticleTypeService.pagelist(dc, 0, tArticleTypeService.findtype().size());
		return "initaddarticle";
		
	}
	public void uploud(String content,String filename){
		String PAGE_HEAD="<!DOCTYPE HTML><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body>";
		String PAGE_TAIL="</body></html>";
		content = PAGE_HEAD + content + PAGE_TAIL;
		String savePath = request.getRealPath("/") + filename;
		File file = new File(savePath);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			fos.write(content.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String pagearticle() throws Exception{
		paginglist1();
		return "pagearticle";
	}
	public String initupdatearticle() throws Exception{
		article = articleService.queryById(article.getIdString());
		DetachedCriteria dc = DetachedCriteria.forClass(TArticleType.class);
		typelist = tArticleTypeService.pagelist(dc, 0, tArticleTypeService.findtype().size());
		return "initupdatearticle";
	}
	public String updasavetearticle() throws Exception{
		String filepath = request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		if(fileupinfo==null){
			fileupinfo = new FileUpInfoVo();
			fileupinfo.setDocFileName(article.getLogoString());
		}else{
			String newname = getFileName(fileupinfo.getDocFileName());
			article.setLogoString("upfile/"+newname);
			FileUtils.copyFile(fileupinfo.getDoc(), new File(filepath,newname));
		}
		String PAGE_HEAD="<!DOCTYPE HTML><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body>";
		String PAGE_TAIL="</body></html>";
		String content = PAGE_HEAD + article.getContentString() + PAGE_TAIL;
		String savePath = request.getRealPath("/") +article.getContenturlString();
		File file = new File(savePath);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			fos.write(content.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(article.getContentString());
		articleService.update(article);
		paginglist1();
		return "updasavetearticle";
	}
	public void paginglist1() throws Exception {
		HttpSession session = request.getSession();
		TManager manager = (TManager)session.getAttribute("manager");
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(3);
		page.setPagebarsum(articleService.count("manageridString",manager.getIdString()));
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
			DetachedCriteria dc = DetachedCriteria.forClass(TArticle.class);
			dc.add(Restrictions.eq("manageridString",manager.getIdString()));
			articleslist = articleService.pagelist(dc,(page.getPagebarsum()-page.getPagebarsize()), page.getPagebarsize());
			page.setStarlocal(page.getPagebarsum()-page.getPagebarsize());
			request.setAttribute("pager", page);
			return;
		}else{
			DetachedCriteria dc = DetachedCriteria.forClass(TArticle.class);
			dc.add(Restrictions.eq("manageridString",manager.getIdString()));
			articleslist = articleService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
			request.setAttribute("pager", page);
		}
	}
	public String deletearticle() throws Exception{
		System.out.println("asdfsfs");
		articleService.delete(article);
		paginglist1();
		return "deletearticle";
	}
	public String deletemanyarticle() throws Exception{
		String idstring[]= id.split(",");
		for(int i=0;i<idstring.length;i++){
			article = new TArticle();
			article.setIdString(idstring[i]);
			logger.info("Ip为："+request.getRemoteAddr()+"的用户正在删除多片资讯,资讯"+i+"编号为"+idstring[i]+"，当前时间为："+new Date().toLocaleString());
			articleService.delete(article);
		}
		paginglist1();
		return "deletemanyarticle";
	}
	public String updatearticlestatus() throws Exception{
		articleService.updatearticlestatus(article);
		paginglist1();
		return "updatearticlestatus";
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}
	private synchronized String getFileName(String filename) {
		int position = filename.lastIndexOf(".");
		String ext = filename.substring(position);
		return System.nanoTime() + ext;
	}
	public String findpwd() throws Exception{
		response.setContentType("text/html;charset=utf-8");
 		PrintWriter out = response.getWriter();
 		try {
 			//用户名
 	 		String Uid = "絮落锦乡";
 	 		//接口安全秘钥
 	 		String Key = "7dc6e6e7cf7ca510a6a4";
 	 		int num = new Random().nextInt(899999)+100000;
 	 		code=num;
 	 		List<TManager> list = managerService.findManager("phoneString", manageraccount);
 	 		if(list.size()==0){
 	 		}else{
 	 			manager = list.get(0);
 	 		}
 	 		manager.setPasswordString(AesUtils.encryptStr(num+"", AesUtils.SECRETKEY));
 	 		managerService.updatepwd(manager);
 	 		out.print(JSON.toJSON("密码修改成功，新密码已发送至你的手机，请查收。"));
 	 		System.out.println(code);
 	 		//短信内容
 	 		String smsText = "【桃源盛景】检测到你正在修改密码:你的新密码为:"+num+"。10分钟之内有效，请妥善保管。";
 	 		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在注册经销商账户,发送手机验证码，当前时间为："+new Date().toLocaleString());
 	 		HttpClientUtil client = HttpClientUtil.getInstance();
 			//UTF发送，测试成功，在开发阶段不会启用，当答辩前一天左右开启
 			int result = client.sendMsgUtf8(Uid, Key, smsText, manageraccount);
 			if(result>0){
 				System.out.println("经销商"+manageraccount+"成功接收"+result+"条短信");
 			}else{
 				System.out.println(client.getErrorMsg(result));
 			}
		} catch (Exception e) {
			out.print(JSON.toJSON("密码修改失败"));
		}
 		return null;
 	}
}
