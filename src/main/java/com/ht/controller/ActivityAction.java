package com.ht.controller;

import java.io.File;
import java.io.FileOutputStream;
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
import com.ht.pojo.TActivity;
import com.ht.pojo.TAgency;
import com.ht.pojo.TBuildings;
import com.ht.pojo.TManager;
import com.ht.service.ActivityService;
import com.ht.service.LouPanService;
import com.opensymphony.xwork2.ActionSupport;

public class ActivityAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private TActivity activity;
	private List<TActivity> activitylist;
	private ActivityService activityService;
	private String id;
	private File file;
	private FileUpInfoVo fileupinfo;
	private List<TBuildings> loupanlist;
	private LouPanService louPanService;
	public List<TBuildings> getLoupanlist() {
		return loupanlist;
	}
	public void setLoupanlist(List<TBuildings> loupanlist) {
		this.loupanlist = loupanlist;
	}
	public LouPanService getLouPanService() {
		return louPanService;
	}
	public void setLouPanService(LouPanService louPanService) {
		this.louPanService = louPanService;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public FileUpInfoVo getFileupinfo() {
		return fileupinfo;
	}
	public void setFileupinfo(FileUpInfoVo fileupinfo) {
		this.fileupinfo = fileupinfo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TActivity getActivity() {
		return activity;
	}
	public void setActivity(TActivity activity) {
		this.activity = activity;
	}
	public List<TActivity> getActivitylist() {
		return activitylist;
	}
	public void setActivitylist(List<TActivity> activitylist) {
		this.activitylist = activitylist;
	}
	public ActivityService getActivityService() {
		return activityService;
	}
	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}
	public String pageactivity() throws Exception{
		paginglist();
		return "pageactivity";
	}
	public String pagemanageractivity() throws Exception{
		pagingmanagerlist();
		return "pagemanageractivity";
	}
	public String initupdateactivity() throws Exception{
		HttpSession session = request.getSession();
		TAgency tagency = (TAgency)session.getAttribute("tagency");
		TManager manager = (TManager)session.getAttribute("manager");
		if(tagency==null){
			loupanlist = louPanService.loupanlist();
		}else{
			loupanlist = louPanService.buildingslist("jxsidString",tagency.getIdString() );
		}
		activity = activityService.queryById(activity.getIdString());
		return "initupdateactivity";
	}
	public String initaddactivity() throws Exception{
		HttpSession session = request.getSession();
		TAgency tagency = (TAgency)session.getAttribute("tagency");
		if(tagency==null){
			loupanlist = louPanService.loupanlist();
		}else{
			loupanlist = louPanService.buildingslist("jxsidString",tagency.getIdString() );
		}
		return "initaddactivity";
	}
	public String deletemanyactivity() throws Exception{
		HttpSession session = request.getSession();
		TAgency tagency = (TAgency)session.getAttribute("tagency");
		String idstring[]= id.split(",");
		for(int i=0;i<idstring.length;i++){
			activity = new TActivity();
			activity.setIdString(idstring[i]);
			activityService.delete(activity);
		}
		if(tagency==null){
			pagingmanagerlist();
		}else{
			paginglist();
		}
		return "deletemanyactivity";
	}
	public String deleteactivity() throws Exception{
		activityService.delete(activity);
		return "deleteactivity";
	}
	public String updateactivitystatus() throws Exception{
		activityService.update(activity);
		return "updateactivitystatus";
	}
	public String updatesaveactivity() throws Exception{
		HttpSession session = request.getSession();
		TManager manager = (TManager)session.getAttribute("manager");
		TAgency tagency = (TAgency)session.getAttribute("tagency");
		String filepath = request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		if(fileupinfo==null){
			fileupinfo = new FileUpInfoVo();
			fileupinfo.setDocFileName(activity.getLogoString());
		}else{
			String newname = getFileName(fileupinfo.getDocFileName());
			activity.setLogoString("upfile/"+newname);
			FileUtils.copyFile(fileupinfo.getDoc(), new File(filepath,newname));
		}
		String PAGE_HEAD="<!DOCTYPE HTML><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body>";
		String PAGE_TAIL="</body></html>";
		String content = PAGE_HEAD + activity.getContentString() + PAGE_TAIL;
		String savePath = request.getRealPath("/") +activity.getUrlString();
		File file = new File(savePath);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			fos.write(content.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(manager==null){
			activity.setJxsidString(tagency.getIdString());
		}else if (tagency==null) {
			activity.setManageridString(manager.getIdString());
		}
		activityService.add(activity);
		if(tagency==null){
			pagingmanagerlist();
		}else{
			paginglist();
		}
		return "updatesaveactivity";
	}
	public String upfile() throws Exception{
		HttpSession session = request.getSession();
		TAgency tagency = (TAgency)session.getAttribute("tagency");
		TManager manager = (TManager)session.getAttribute("manager");
		String filepath = request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		String newname = getFileName(fileupinfo.getDocFileName());
		activity.setLogoString("upfile/"+newname);
		FileUtils.copyFile(fileupinfo.getDoc(), new File(filepath,newname));
		long filename = System.currentTimeMillis();
		String msgContentUrl="upfile/"+filename+".html";
		uploud(activity.getContentString(), msgContentUrl);
		activity.setStatusInt(0);
		activity.setUrlString(msgContentUrl);
		if(manager==null){
			activity.setJxsidString(tagency.getIdString());
		}else if (tagency==null) {
			activity.setManageridString(manager.getIdString());
		}
		activityService.add(activity);
		if(tagency==null){
			pagingmanagerlist();
		}else{
			paginglist();
		}
		return "upfile";
		
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
	private synchronized String getFileName(String filename) {
		int position = filename.lastIndexOf(".");
		String ext = filename.substring(position);
		return System.nanoTime() + ext;
	}
	public void paginglist() throws Exception {
		HttpSession session = request.getSession();
 		TAgency tagency = (TAgency)session.getAttribute("tagency");
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(10);
		page.setPagebarsum(activityService.count("jxsidString",tagency.getIdString()));
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
		DetachedCriteria dc = DetachedCriteria.forClass(TActivity.class);
		dc.add(Restrictions.eq("jxsidString",tagency.getIdString()));
		activitylist = activityService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
		request.setAttribute("pager", page);

	}
	public void pagingmanagerlist() throws Exception {
		HttpSession session = request.getSession();
		TManager manager = (TManager)session.getAttribute("manager");
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(4);
		page.setPagebarsum(activityService.count("manageridString",manager.getIdString()));
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
		DetachedCriteria dc = DetachedCriteria.forClass(TActivity.class);
		dc.add(Restrictions.eq("manageridString",manager.getIdString()));
		activitylist = activityService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
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
