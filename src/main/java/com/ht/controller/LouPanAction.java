package com.ht.controller;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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

import com.alibaba.fastjson.JSON;
import com.ht.pojo.FileUpInfoVo;
import com.ht.pojo.PagingBean;
import com.ht.pojo.TAgency;
import com.ht.pojo.TBaobiao;
import com.ht.pojo.TBuilding;
import com.ht.pojo.TBuildings;
import com.ht.pojo.TEmployee;
import com.ht.service.LouPanService;
import com.opensymphony.xwork2.ActionSupport;

public class LouPanAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(LouPanAction.class);
	private LouPanService louPanService;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private List<TBuildings> loupanlist;
	private TBuildings loupan;
	private FileUpInfoVo fileupinfo;
	private String fileFileName; // 文件名称
	private String local;
	private File file;
	private String listjson;
	private String id;
	private TBuilding loudong;
	private TAgency tagency;
	private String startTime;
	private String endTime;
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	HttpSession session = null;
	public TAgency getTagency() {
		tagency = (TAgency)session.getAttribute("tagency");
		return tagency;
	}

	public void setTagency(TAgency tagency) {
		this.tagency = tagency;
	}
	public TBuilding getLoudong() {
		return loudong;
	}

	public void setLoudong(TBuilding loudong) {
		this.loudong = loudong;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getListjson() {
		return listjson;
	}

	public void setListjson(String listjson) {
		this.listjson = listjson;
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
	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}


	public TBuildings getLoupan() {
		return loupan;
	}

	public void setLoupan(TBuildings loupan) {
		this.loupan = loupan;
	}

	public List<TBuildings> getLoupanlist() {
		return loupanlist;
	}

	public void setLoupanlist(List<TBuildings> loupanlist) {
		this.loupanlist = loupanlist;
	}

	public void setLouPanService(LouPanService louPanService) {
		this.louPanService = louPanService;
	}
	

	public FileUpInfoVo getFileupinfo() {
		return fileupinfo;
	}

	public void setFileupinfo(FileUpInfoVo fileupinfo) {
		this.fileupinfo = fileupinfo;
	}
	public String loupanlist() throws Exception {
		HttpSession session = request.getSession();
		tagency = (TAgency)session.getAttribute("tagency");
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在查看楼盘列表，当前时间为："+new Date().toLocaleString());
		loupanlist = new ArrayList<TBuildings>();
		loupanlist = louPanService.buildingslist("jxsidString",tagency.getIdString());
		tagency=loupan.getTagency();
		loupanlist = louPanService.loupanlist();
		return "loupanlist";
	}
	public String showloupan() throws Exception {
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在查看单个id为"+loupan.getIdString()+"楼盘的信息，当前时间为："+new Date().toLocaleString());
		loupan = louPanService.queryById(loupan.getIdString());
		tagency = loupan.getTagency();
		return "showloupan";
	}
	public String updateloupan() throws Exception {
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在更新id为"+loupan.getIdString()+"楼盘的信息，当前时间为："+new Date().toLocaleString());
		List<TBuildings> oneloupan = louPanService.findloupan(loupan.getIdString());
		loupan = oneloupan.get(0);
		return "updateloupan";
	}
	public String updatelpstatus() throws Exception {
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在更新id为"+loupan.getIdString()+"楼盘的状态，当前时间为："+new Date().toLocaleString());
		louPanService.update(loupan);
		loupanlist = louPanService.loupanlist();
		return "pageloupan";
	}

	public String deletelpstatus() throws Exception {
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在删除id为"+loupan.getIdString()+"楼盘的信息，当前时间为："+new Date().toLocaleString());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		loupan.setIdString(loupan.getIdString());
		louPanService.delete(loupan);
		out.print("删除成功");
		return "deletelpstatus";
	}
	public String baobiao() throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<TBaobiao> l = new ArrayList<TBaobiao>();
		@SuppressWarnings("rawtypes")
		List list = louPanService.baobiao();
		for(int i=0;i<list.size();i++){
			double d[]=new double[13];
			TBaobiao baobiao = new TBaobiao();
			Object [] object = (Object [])list.get(i);
			d[Integer.parseInt(object[2].toString())] = Double.parseDouble((object[0].toString()));
			baobiao.setName(object[1].toString());
			baobiao.setData(d);
			l.add(baobiao);
		}
		out.print(JSON.toJSONString(l));
		return null;
	}
	public String addloupan() throws Exception {
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正新增楼盘，当前时间为："+new Date().toLocaleString());
		try {
			String path = fileupinfo.getDocFileName();
		} catch (Exception e) {
			louPanService.add(loupan);
			loupanlist = louPanService.loupanlist();
			return "pageloupan";
		}	
		if(!fileupinfo.getDoc().equals("") || fileupinfo.getDoc()!=null){
			String filepath = request.getRealPath("/")+"upfile"; 
			File file = new File(filepath);
			if (!file.exists()) {
				file.mkdir();
			}
			fileupinfo.setFilename(getFileName(fileupinfo.getDocFileName()));
			String newname = getFileName(fileupinfo.getFilename());
			logger.info("Ip为："+request.getRemoteAddr()+"的用户正更新楼盘并且上传了一张名为"+newname+"的图片，当前时间为："+new Date().toLocaleString());
			loupan.setLogoString("upfile/"+newname);
			FileUtils.copyFile(fileupinfo.getDoc(), new File(filepath,newname));
		}
		louPanService.add(loupan);
		loupanlist = louPanService.loupanlist();
		return "pageloupan";
	}
	public String pageloupan() throws Exception {
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在分页查看楼盘，当前时间为："+new Date().toLocaleString());
		loupanlist = louPanService.loupanlist();
		return "pageloupan";
	}
	public String  deletemanyloupan() throws Exception{
		String idstring[]= id.split(",");
		for(int i=0;i<idstring.length;i++){
			loupan = new TBuildings();
			loupan.setIdString(idstring[i]);
			logger.info("Ip为："+request.getRemoteAddr()+"的用户正在删除多个楼盘,楼盘"+i+"编号为"+idstring[i]+"，当前时间为："+new Date().toLocaleString());
			louPanService.delete(loupan);
		}
		loupanlist = louPanService.loupanlist();
		return "pageloupan";
	}
//	public String fileUpload() throws Exception {
//		System.out.println("===========-------------");
//		String filepath = request.getRealPath("/")+"upfile"; 
//		File file1 = new File(filepath);
//		if (!file1.exists()) {
//			file1.mkdir();
//		}
//		System.out.println(file+"=========");
//		FileUtils.copyFile(file, new File(filepath,getFileName(fileFileName)));
//		return "fileUpload";
//	}

	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	
	public void setServletRequest(HttpServletRequest request) {
		 session = request.getSession();
		this.request = request;
	}
	private synchronized String getFileName(String filename) {
		int position = filename.lastIndexOf(".");
		String ext = filename.substring(position);
		return System.nanoTime() + ext;
	}

}
