package com.ht.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ht.pojo.PagingBean;
import com.ht.pojo.TAgency;
import com.ht.pojo.TBuilding;
import com.ht.pojo.TBuildings;
import com.ht.pojo.TEmployee;
import com.ht.service.LouDongService;
import com.ht.service.LouPanService;
import com.opensymphony.xwork2.ActionSupport;

public class LouDongAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(LouPanAction.class);

	private LouDongService louDongService;

	private HttpServletRequest request;
	
	private HttpServletResponse response;
	
	private LouPanService louPanService;
	
	private List<TBuildings> loupanlist;
	
	private TBuilding loudong;
	
	private TBuildings loupan;
	
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

	public TAgency getTagency() {
		return tagency;
	}

	public void setTagency(TAgency tagency) {
		this.tagency = tagency;
	}
	private TAgency tagency;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	private List<TBuilding> loudonglist;
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

	public TBuildings getLoupan() {
		return loupan;
	}

	public void setLoupan(TBuildings loupan) {
		this.loupan = loupan;
	}
	
	public TBuilding getLoudong() {
		return loudong;
	}

	public void setLoudong(TBuilding loudong) {
		this.loudong = loudong;
	}

	public List<TBuilding> getLoudonglist() {
		return loudonglist;
	}

	public void setLoudonglist(List<TBuilding> loudonglist) {
		this.loudonglist = loudonglist;
	}

	public LouDongService getLouDongService() {
		return louDongService;
	}

	public void setLouDongService(LouDongService louDongService) {
		this.louDongService = louDongService;
	}

	
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}

	
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	public String pageloudong() throws Exception{
		paginglist();
		return "pageloudong";
	}
	public String loupanlist() throws Exception{
		HttpSession session = request.getSession();
		tagency = (TAgency)session.getAttribute("tagency");
		loupanlist = new ArrayList<TBuildings>();
		loupanlist = louPanService.buildingslist("jxsidString",tagency.getIdString());
		return "loupanlist";
	}
	public String deletemanyloudong() throws Exception{
		String idstring[]= id.split(",");
		for(int i=0;i<idstring.length;i++){
			loudong = new TBuilding();
			loudong.setIdString(idstring[i]);
			logger.info("Ip为："+request.getRemoteAddr()+"的用户正在删除多个楼栋,楼栋"+i+"编号为"+idstring[i]+"，当前时间为："+new Date().toLocaleString());
			louDongService.delete(loudong);
		}
		paginglist();
		return "deletemanyloudong";
	}
	public String deleteld() throws Exception{
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在删除id为"+loudong.getIdString()+"楼栋的信息，当前时间为："+new Date().toLocaleString());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		loudong.setIdString(loudong.getIdString());
		louDongService.delete(loudong);
		out.print("删除成功");
		return "deleteld";
	}
	public String updatelpstatus() throws Exception{
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在更新id为"+loudong.getIdString()+"楼栋的状态，当前时间为："+new Date().toLocaleString());
		loudong.setIdString(loudong.getIdString());
		loudong.setStatusInt(loudong.getStatusInt());
		louDongService.update(loudong);
		return "updatelpstatus";
		
	}
	public String showloudong() throws Exception{
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在查看单个id为"+loudong.getIdString()+"楼栋的信息，当前时间为："+new Date().toLocaleString());
		loudong = louDongService.queryById(loudong.getIdString());
		loupan = loudong.getBuildings();
		System.out.println(loupan.getNameString());
		return "showloudong";
	}
	public String updateloudong() throws Exception {
		HttpSession session = request.getSession();
		tagency = (TAgency)session.getAttribute("tagency");
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在更新id为"+loudong.getIdString()+"楼盘的信息，当前时间为："+new Date().toLocaleString());
		List<TBuilding> oneloudong = louDongService.findloudong(loudong.getIdString());
		loudong = oneloudong.get(0);
		loupanlist = new ArrayList<TBuildings>();
		loupanlist = louPanService.buildingslist("jxsidString",tagency.getIdString());
		return "updateloudong";
	}
	public String deletelpstatus() throws Exception {
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在删除id为"+loudong.getIdString()+"楼盘的信息，当前时间为："+new Date().toLocaleString());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		loudong.setIdString(loudong.getIdString());
		louDongService.delete(loudong);
		out.print("删除成功");
		return "deletelpstatus";
	}
	public String addloudong() throws Exception{
		HttpSession session = request.getSession();
		tagency = (TAgency)session.getAttribute("tagency");
		loudong.setBuildingsId(loupan.getIdString());
		loudong.setTotalRoomInt((loudong.getFloorRoomsInt()*loudong.getTotalFloorInt()));
		loudong.setCreatedTimeString(new Date());
		loudong.setStatusInt(0);
		loudong.setJxsidString(tagency.getIdString());
		louDongService.add(loudong);
		paginglist();
		return "addloudong";
	}
	public void paginglist() throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		HttpSession session = request.getSession();
		tagency = (TAgency)session.getAttribute("tagency");
		TEmployee employee = (TEmployee)session.getAttribute("employee");
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(10);
		if(tagency==null){
			if(startTime==null || endTime==null || startTime.equals("") || endTime.equals("")){
				page.setPagebarsum(louDongService.count("jxsidString", employee.getAngencyIdString()));
			}else{
				DetachedCriteria dc = DetachedCriteria.forClass(TBuilding.class);
				dc.add(Restrictions.between("createdTimeString", df.parse(startTime+" 00:00:00"), df.parse(endTime+" 23:59:59")));
				dc.add(Restrictions.eq("jxsidString", employee.getAngencyIdString()));
				page.setPagebarsum(louDongService.pagecount(dc));
			}
		}else{
			if(startTime==null || endTime==null || startTime.equals("") || endTime.equals("")){
				page.setPagebarsum(louDongService.count("jxsidString", tagency.getIdString()));
			}else{
				DetachedCriteria dc = DetachedCriteria.forClass(TBuilding.class);
				dc.add(Restrictions.between("createdTimeString", df.parse(startTime+" 00:00:00"), df.parse(endTime+" 23:59:59")));
				dc.add(Restrictions.eq("jxsidString", tagency.getIdString()));
				page.setPagebarsum(louDongService.pagecount(dc));
			}
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
		DetachedCriteria dc = DetachedCriteria.forClass(TBuilding.class);
		if(tagency==null){
			if(startTime==null || endTime==null || startTime.equals("") || endTime.equals("")){
				dc.add(Restrictions.eq("jxsidString",employee.getAngencyIdString()));
			}else{
				dc.add(Restrictions.between("createdTimeString", df.parse(startTime+" 00:00:00"), df.parse(endTime+" 23:59:59")));
				dc.add(Restrictions.eq("jxsidString",employee.getAngencyIdString()));
			}
		}else{
			if(startTime==null || endTime==null || startTime.equals("") || endTime.equals("")){
				dc.add(Restrictions.eq("jxsidString",tagency.getIdString()));
			}else{
				dc.add(Restrictions.between("createdTimeString", df.parse(startTime+" 00:00:00"), df.parse(endTime+" 23:59:59")));
				dc.add(Restrictions.eq("jxsidString",tagency.getIdString()));
			}
		}
		loudonglist = louDongService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
		request.setAttribute("pager", page);
	}
}
