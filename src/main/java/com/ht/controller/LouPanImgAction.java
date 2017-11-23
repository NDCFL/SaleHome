package com.ht.controller;

import java.io.File;
import java.util.ArrayList;
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
import org.hibernate.criterion.Restrictions;

import com.ht.pojo.PagingBean;
import com.ht.pojo.TAgency;
import com.ht.pojo.TBuildings;
import com.ht.pojo.TBuildingsImg;
import com.ht.service.LouPanImgService;
import com.ht.service.LouPanService;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xerces.internal.impl.xs.SchemaSymbols;

public class LouPanImgAction extends ActionSupport implements ServletResponseAware,ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(LouPanAction.class);
	private LouPanImgService louPanImgService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String fileFileName; 
	private File file;
	private TAgency tagency;
	private List<TBuildingsImg> loupanimglist;
	private LouPanService louPanService;
	private List<TBuildings> loupanlist ;
	private TBuildingsImg img;
	private String imgid;
	private int num=0;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	private static List<String> imglist = new ArrayList<String>();;
	public String getImgid() {
		return imgid;
	}
	public void setImgid(String imgid) {
		this.imgid = imgid;
	}
	public TBuildingsImg getImg() {
		return img;
	}
	public void setImg(TBuildingsImg img) {
		this.img = img;
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
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<TBuildingsImg> getLoupanimglist() {
		return loupanimglist;
	}
	public void setLoupanimglist(List<TBuildingsImg> loupanimglist) {
		this.loupanimglist = loupanimglist;
	}
	public TAgency getTagency() {
		return tagency;
	}
	public void setTagency(TAgency tagency) {
		this.tagency = tagency;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public LouPanImgService getLouPanImgService() {
		return louPanImgService;
	}
	public void setLouPanImgService(LouPanImgService louPanImgService) {
		this.louPanImgService = louPanImgService;
	}
	public String initaddloupanimg() throws Exception{
		HttpSession session = request.getSession();
		tagency = (TAgency)session.getAttribute("tagency");
		loupanlist = louPanService.buildingslist("jxsidString", tagency.getIdString());
		return "initaddloupanimg";
	}
	public String fileUpload() throws Exception {
		HttpSession session = request.getSession();
		tagency = (TAgency)session.getAttribute("tagency");
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在上传楼盘的图片，当前时间为："+new Date().toLocaleString());
		String filepath = request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		String newname = getFileName(fileFileName);
		imglist.add("upfile/"+newname);
		FileUtils.copyFile(file, new File(filepath,newname));
		return "fileUpload";
	}
	public String addloupanimg() throws Exception{
		HttpSession session = request.getSession();
		tagency = (TAgency)session.getAttribute("tagency");
		String id = img.getBuildingsIdString();
		for(int i=0;i<imglist.size();i++){
			System.out.println(imglist.get(i));
			img = new TBuildingsImg();
			img.setImgPathString(imglist.get(i));
			img.setCreatedTime(new Date());
			img.setJxsidString(tagency.getIdString());
			img.setBuildingsIdString(id);
			img.setImgDesString("楼盘图片");
			louPanImgService.add(img);
		}
		paginglist();
		return "addloupanimg";
	}
	public String pageloupanimg() throws Exception{
		paginglist();
		return "pageloupanimg";
	}
	public String deleteimg() throws Exception{
		louPanImgService.delete(img);
		return "deleteimg";
	}
	public String deletemanyloupanimg() throws Exception{
		String idstring[]= id.split(",");
		for(int i=0;i<idstring.length;i++){
			img = new TBuildingsImg();
			img.setIdString(idstring[i]);
			logger.info("Ip为："+request.getRemoteAddr()+"的用户正在删除多个楼盘图片,楼盘图片"+i+"编号为"+idstring[i]+"，当前时间为："+new Date().toLocaleString());
			louPanImgService.delete(img);
		}
		paginglist();
		return "deletemanyloupanimg";
	}
	public String deletemanyimg() throws Exception{
		String idstring[]= id.split(",");
		for(int i=0;i<idstring.length;i++){
			img = new TBuildingsImg();
			img.setIdString(idstring[i]);
			logger.info("Ip为："+request.getRemoteAddr()+"的用户正在删除多个楼盘图片,楼盘图片"+i+"编号为"+idstring[i]+"，当前时间为："+new Date().toLocaleString());
			louPanImgService.delete(img);
		}
		paginglist();
		return "deletemanyimg";
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}
	public String showloupanimg() throws Exception{
		loupanimglist = louPanImgService.loupanimglist();
		num = loupanimglist.size();
		return "showloupanimg";
	}
	
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}
	private synchronized String getFileName(String filename) {
		int position = filename.lastIndexOf(".");
		String ext = filename.substring(position);
		return System.nanoTime() + ext;
	}
	public void paginglist() throws Exception {
		HttpSession session = request.getSession();
		tagency = (TAgency)session.getAttribute("tagency");
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(10);
		page.setPagebarsum(louPanImgService.count("jxsidString", tagency.getIdString()));
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
//		if((page.getStarlocal()+page.getPagebarsize())>=page.getPagebarsum()){
//			DetachedCriteria dc = DetachedCriteria.forClass(TBuildingsImg.class);
//			dc.add(Restrictions.eq("jxsidString",tagency.getIdString()));
//			loupanimglist = louPanImgService.pagelist(dc,(page.getPagebarsum()-page.getPagebarsize()), page.getPagebarsize());
//			page.setStarlocal(page.getPagebarsum()-page.getPagebarsize());
//			request.setAttribute("pager", page);
//			return;
//		}else{
			DetachedCriteria dc = DetachedCriteria.forClass(TBuildingsImg.class);
			dc.add(Restrictions.eq("jxsidString",tagency.getIdString()));
			System.out.println(page.getStarlocal()+"========");
			loupanimglist = louPanImgService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
			request.setAttribute("pager", page);
//		}
	}

}
