package com.ht.controller;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
import com.ht.pojo.TBuilding;
import com.ht.pojo.TBuildings;
import com.ht.pojo.THouse;
import com.ht.service.HouseService;
import com.ht.service.LouDongService;
import com.ht.service.LouPanService;
import com.opensymphony.xwork2.ActionSupport;

public class HouseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(LouPanAction.class);
	private HouseService houseService;
	private List<THouse> houselist;
	private TBuilding tbuilding;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private THouse house;
	private LouPanService louPanService;
	private TAgency tagency;
	private List<TBuildings> loupanlist;
	private List<TBuilding> loudonglist;
	private LouDongService louDongService;
	private FileUpInfoVo fileupinfo;
	private TBuildings loupan;
	private String fileFileName; // 文件名称
	private String id;
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
	private File file;
	
	public TBuildings getLoupan() {
		return loupan;
	}
	public void setLoupan(TBuildings loupan) {
		this.loupan = loupan;
	}
	public LouDongService getLouDongService() {
		return louDongService;
	}
	public void setLouDongService(LouDongService louDongService) {
		this.louDongService = louDongService;
	}
	public List<TBuildings> getLoupanlist() {
		return loupanlist;
	}
	public void setLoupanlist(List<TBuildings> loupanlist) {
		this.loupanlist = loupanlist;
	}
	public List<TBuilding> getLoudonglist() {
		return loudonglist;
	}
	public void setLoudonglist(List<TBuilding> loudonglist) {
		this.loudonglist = loudonglist;
	}
	public TAgency getTagency() {
		return tagency;
	}
	public void setTagency(TAgency tagency) {
		this.tagency = tagency;
	}
	public LouPanService getLouPanService() {
		return louPanService;
	}
	public void setLouPanService(LouPanService louPanService) {
		this.louPanService = louPanService;
	}
	public THouse getHouse() {
		return house;
	}
	public void setHouse(THouse house) {
		this.house = house;
	}
	public List<THouse> getHouselist() {
		return houselist;
	}
	public void setHouselist(List<THouse> houselist) {
		this.houselist = houselist;
	}
	public TBuilding getTbuilding() {
		return tbuilding;
	}
	public void setTbuilding(TBuilding tbuilding) {
		this.tbuilding = tbuilding;
	}
	public HouseService getHouseService() {
		return houseService;
	}
	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}
	public String pagehouse() throws Exception{
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在分页查看户型的详细信息，当前时间为："+new Date().toLocaleString());
		paginglist();
		return "pagehouse";
	}
	public String showhouse() throws Exception{
		house = houseService.queryById(house.getIdString());
		tbuilding = house.getTbuilding();
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在查看"+tbuilding.getBuildings().getTagency().getIdString()+"经销商的"+house.getTbuilding().getBuildings().getIdString()+"楼盘"+house.getTbuilding().getIdString()+"楼栋"+house.getIdString()+"户型的详细信息，当前时间为："+new Date().toLocaleString());
		return "showhouse";
	}
	public String updatehxstatus() throws Exception{
		house.setIdString(house.getIdString());
		house.setStatusInt(house.getStatusInt());
		houseService.update(house);
		if(house.getStatusInt()==0){
			logger.info("Ip为："+request.getRemoteAddr()+"的用户正在开售"+tbuilding.getBuildings().getTagency().getIdString()+"经销商的"+house.getTbuilding().getBuildings().getIdString()+"楼盘"+house.getTbuilding().getIdString()+"楼栋"+house.getIdString()+"户型，当前时间为："+new Date().toLocaleString());
		}else{
			logger.info("Ip为："+request.getRemoteAddr()+"的用户正在售罄"+tbuilding.getBuildings().getTagency().getIdString()+"经销商的"+house.getTbuilding().getBuildings().getIdString()+"楼盘"+house.getTbuilding().getIdString()+"楼栋"+house.getIdString()+"户型，当前时间为："+new Date().toLocaleString());
		}
		return "updatehxstatus";
	}
	public String lpldlist() throws Exception{
		HttpSession session = request.getSession();
		tagency = (TAgency)session.getAttribute("tagency");
		loupanlist = louPanService.buildingslist("jxsidString", tagency.getIdString());
		tbuilding.setIdString(tbuilding.getIdString());
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在修改户型，当前操作为初始化楼，当前时间为："+new Date().toLocaleString());
		return "lpldlist";
	}
	public String getloudong() throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		loudonglist = louDongService.loudonglist("buildingsId", loupan.getIdString());
		String value = JSON.toJSONString(loudonglist);
		out.print(value);
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在修改户型，当前操作为通过"+loupan.getIdString()+"楼盘查找出楼栋列表，当前时间为："+new Date().toLocaleString());
		return null;
	}
	public String updatesave() throws Exception{
		HttpSession session = request.getSession();
		TAgency tagency = (TAgency)session.getAttribute("tagency");
		String filepath = request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		if(fileFileName==null){
		
			
		}else if(fileFileName!=null){
			System.out.println(fileFileName);
			String newname = getFileName(fileFileName);
			logger.info("Ip为："+request.getRemoteAddr()+"的用户正在修改户型上传了一张名为"+newname+"的图片，当前时间为："+new Date().toLocaleString());
			house.setLogoString("upfile/"+newname);
			FileUtils.copyFile(file, new File(filepath,newname));
		}
		house.setJxsidString(tagency.getIdString());
		houseService.add(house);
		paginglist();
		return "updatesave";
	}
	public String addhouse() throws Exception{
		HttpSession session = request.getSession();
		TAgency tagency = (TAgency)session.getAttribute("tagency");
		String filepath = request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		String newname = getFileName(fileFileName);
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在新增户型上传了一张名为"+newname+"的图片，当前时间为："+new Date().toLocaleString());
		house.setLogoString("upfile/"+newname);
		FileUtils.copyFile(file, new File(filepath,newname));
		house.setStatusInt(0);
		house.setCreatedTime(new Date());
		house.setJxsidString(tagency.getIdString());
		houseService.add(house);
		paginglist();
		return "addhouse";
	}
	public String deletehouse() throws Exception{
		house.setIdString(house.getIdString());
		houseService.delete(house);
		paginglist();
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在删除"+house.getIdString()+"户型当前时间为："+new Date().toLocaleString());
		return "deletehouse";
	}
	public String  deletemanyhouse() throws Exception{
		String idstring[]= id.split(",");
		for(int i=0;i<idstring.length;i++){
			house = new THouse();
			house.setIdString(idstring[i]);
			logger.info("Ip为："+request.getRemoteAddr()+"的用户正在删除多个户型,户型"+i+"编号为"+idstring[i]+"，当前时间为："+new Date().toLocaleString());
			houseService.delete(house);
		}
		paginglist();
		return "deletemanyhouse";
	}
	public String updatehouse() throws Exception{
		HttpSession session = request.getSession();
		tagency = (TAgency)session.getAttribute("tagency");
		loupanlist = louPanService.buildingslist("jxsidString", tagency.getIdString());
		house = houseService.queryById(house.getIdString());
		loudonglist = louDongService.loudonglist("buildingsId", house.getTbuilding().getBuildings().getIdString());
		tbuilding = house.getTbuilding();
		logger.info("Ip为："+request.getRemoteAddr()+"的用户准备修改户型，当前时间为："+new Date().toLocaleString());
		return "updatehouse";
	}
	public void paginglist() throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(10);
		if(startTime==null || endTime==null || startTime.equals("") || endTime.equals("")){
			page.setPagebarsum(houseService.count("buildidString",tbuilding.getIdString()));
		}else{
			DetachedCriteria dc = DetachedCriteria.forClass(THouse.class);
			dc.add(Restrictions.between("createdTime", df.parse(startTime+" 00:00:00"), df.parseObject(endTime+" 23:59:59")));
			dc.add(Restrictions.eq("buildidString",tbuilding.getIdString()));
			page.setPagebarsum(houseService.pagecount(dc));
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
		DetachedCriteria dc = DetachedCriteria.forClass(THouse.class);
		if(startTime==null || endTime==null || startTime.equals("") || endTime.equals("")){
			dc.add(Restrictions.eq("buildidString", tbuilding.getIdString()));
		}else{
			dc.add(Restrictions.eq("buildidString", tbuilding.getIdString()));
			dc.add(Restrictions.between("createdTime", df.parse(startTime+" 00:00:00"), df.parseObject(endTime+" 23:59:59")));
		}
		houselist = houseService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
		tbuilding.setIdString(tbuilding.getIdString());
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
