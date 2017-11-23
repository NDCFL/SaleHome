package com.ht.controller;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.ht.API.SendEmail;
import com.ht.pluspassword.AesUtils;
import com.ht.pojo.FileUpInfoVo;
import com.ht.pojo.PagingBean;
import com.ht.pojo.TAgency;
import com.ht.pojo.TBuilding;
import com.ht.pojo.TBuildings;
import com.ht.pojo.TUser;
import com.ht.service.TAgencyService;
import com.ht.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class TagneyAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private TAgency tagency;
	private TAgencyService tAgencyService;
	private TBuilding lodong;
	private TBuildings loupan;
	private String newpassword;
	private String newpassword2;
	private List<TAgency> tagencylist;
	private UserService userService;
	private TUser user;
	private String starttime;
	private String endtime;
	private File file;
	private String fileFileName;
	private FileUpInfoVo fileUpInfoVo;
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
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
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
	public List<TAgency> getTagencylist() {
		return tagencylist;
	}
	public void setTagencylist(List<TAgency> tagencylist) {
		this.tagencylist = tagencylist;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getNewpassword2() {
		return newpassword2;
	}
	public void setNewpassword2(String newpassword2) {
		this.newpassword2 = newpassword2;
	}
	public TBuilding getLodong() {
		return lodong;
	}
	public void setLodong(TBuilding lodong) {
		this.lodong = lodong;
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
	public String initpwd() throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		TAgency t = (TAgency)session.getAttribute("tagency");
		tagency = tAgencyService.queryById(t.getIdString());
		out.print(AesUtils.decryptStr(tagency.getPwdString(), AesUtils.SECRETKEY));
		return null;
	}
	public String showjxs() throws Exception{
		tagency = tAgencyService.queryById(tagency.getIdString());
		return "showjxs";
	}
	public String updatejxs() throws Exception{
		tagency = tAgencyService.queryById(tagency.getIdString());
		return "updatejxs";
	}
	public String updatejxsstatus() throws Exception{
		tAgencyService.changestatus("t.statusInt",tagency.getStatusInt()+"", tagency.getIdString());
		return "updatejxsstatus";
	}
	public String updatejxscheckedStatusInt() throws Exception{
		tAgencyService.changestatus("t.checkedStatusInt",tagency.getCheckedStatusInt()+"", tagency.getIdString());
		return "updatejxscheckedStatusInt";
	}
	public String addtagency() throws Exception{
		HttpSession session = request.getSession();
		TAgency t = (TAgency)session.getAttribute("tagency");
		tagency.setIdString(t.getIdString());
		tagency.setCreatedTime(t.getCreatedTime());
		tagency.setCheckedStatusInt(t.getCheckedStatusInt());
		tagency.setStatusInt(t.getStatusInt());
		tagency.setLogoString(t.getLogoString());
		tagency.setLeaderString(t.getLeaderString());
		tagency.setPwdString(t.getPwdString());
		tagency.setTbuildset(new HashSet<TBuilding>());
		tagency.setBuildsset(new HashSet<TBuildings>());
		tAgencyService.add(tagency);
		session.setAttribute("tagency", tAgencyService.queryById(t.getIdString()));
		return "addtagency";
	}
	public String updatepwd() throws Exception{
		HttpSession session = request.getSession();
		TAgency t = (TAgency)session.getAttribute("tagency");
		tagency = new TAgency();
		tagency.setCheckedStatusInt(t.getCheckedStatusInt());
		tagency.setStatusInt(t.getStatusInt());
		tagency.setPwdString(AesUtils.encryptStr(newpassword, AesUtils.SECRETKEY));
		tagency.setIdString(t.getIdString());
		tAgencyService.update(tagency);
		return "updatepwd";
	}
	public String jxslist() throws Exception{
		paginglist();
		return "jxslist";
	}
	public String shenhejxs() throws Exception{
		tAgencyService.shenhe(tagency);
		String receiveEmail = tagency.getEmailString()+"";
        String receiveNick="陈飞龙";
        String subject="【桃源盛景】";
        String contents="";
        if(tagency.getCheckedStatusInt()==2){
        	contents = "【桃源盛景】尊敬的用户你好你提交的经销商审核结果为:审核通过.";
        	user.setUsertypeInt(1);
			userService.update(user);
        }else if(tagency.getCheckedStatusInt()==3){
        	contents = "【桃源盛景】尊敬的用户你好你提交的经销商审核结果为:审核不通过。理由"+tagency.getReasonString();
        }else if(tagency.getCheckedStatusInt()==4){
        	contents = "【桃源盛景】尊敬的用户你好你提交的经销商审核结果为:审核被拒绝。理由"+tagency.getReasonString();
        }
        SendEmail.sendMail(receiveEmail, receiveNick, subject, contents);
        System.out.println("邮箱发送成功！");
        paginglist();
		return "shenhejxs";
	}
	public String sousuo() throws Exception{
		pagingsousuolist();
		return "sousuo";
	}
	private synchronized String getFileName(String filename) {
		int position = filename.lastIndexOf(".");
		String ext = filename.substring(position);
		return System.nanoTime() + ext;
	}
	public String uplogo() throws Exception{
		HttpSession session = request.getSession();
		String filepath =request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		if(fileFileName==null || fileFileName.equals("")){
			tAgencyService.updatelogo(tagency);
		}else{
			String newname = getFileName(fileFileName);
			FileUtils.copyFile(file, new File(filepath,newname));
			tagency.setLogoString("upfile/"+newname);
			tAgencyService.updatelogo(tagency);
		}
		session.setAttribute("tagency", tAgencyService.queryById(tagency.getIdString()));
		return "uplogo";
	}
	public String findmylogo() throws Exception{
		tagency = tAgencyService.queryById(tagency.getIdString());
		return "findmylogo";
	}
	public String inituplogo() throws Exception{
		tagency = tAgencyService.queryById(tagency.getIdString());
		return "inituplogo";
	}
	public void pagingsousuolist() throws Exception{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		PagingBean page = new PagingBean();
		page.setPagebarsize(10);
		if(starttime==null || endtime==null || starttime.equals("") || endtime.equals("")){
			page.setPagebarsum(tAgencyService.likecount(starttime+" 00:00:00", endtime+" 23:59:59", tagency.getNameString()));
		}else{
			page.setPagebarsum(tAgencyService.count("", ""));
		}
		String currentpage = request.getParameter("currentpage");
		String handle = request.getParameter("handle");
		if(currentpage==null || currentpage.equals("")){
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
		DetachedCriteria dc = DetachedCriteria.forClass(TAgency.class);
		dc.add(Restrictions.like("nameString", tagency.getNameString(),MatchMode.ANYWHERE));
		if(starttime==null && starttime==null){
			
		}else{
			dc.add(Restrictions.between("createdTime", df.parse(starttime+" 00:00:00"), df.parse(endtime+" 23:59:59")));
		}	
		tagencylist = tAgencyService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
		request.setAttribute("pager", page);
		request.setAttribute("oeder", "find");
	}
	public void paginglist() throws Exception {
		HttpSession session = request.getSession();
		tagency = (TAgency)session.getAttribute("tagency");
		PagingBean page = new PagingBean();
		page.setPagebarsize(3);
		page.setPagebarsum(tAgencyService.count("", ""));
		String currentpage = request.getParameter("currentpage");
		String handle = request.getParameter("handle");
		if(currentpage==null || currentpage.equals("")){
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
		if((page.getStarlocal()+page.getPagebarsize())>=page.getPagebarsum()){
			DetachedCriteria dc = DetachedCriteria.forClass(TAgency.class);
			dc.addOrder(Order.desc("createdTime"));
			tagencylist = tAgencyService.pagelist(dc,(page.getPagebarsum()-page.getPagebarsize()), page.getPagebarsize());
			page.setStarlocal(page.getPagebarsum()-page.getPagebarsize());
			request.setAttribute("pager", page);
			return;
		}else{
			DetachedCriteria dc = DetachedCriteria.forClass(TAgency.class);
			dc.addOrder(Order.desc("createdTime"));
			tagencylist = tAgencyService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
			request.setAttribute("pager", page);
		}
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}
	
}
