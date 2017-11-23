package com.ht.controller;

import java.io.PrintWriter;
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
import org.hibernate.loader.plan.exec.process.spi.ReturnReader;

import com.alibaba.fastjson.JSON;
import com.ht.pojo.PagingBean;
import com.ht.pojo.TAgency;
import com.ht.pojo.TBuilding;
import com.ht.pojo.THouse;
import com.ht.pojo.TRoom;
import com.ht.service.HouseService;
import com.ht.service.LouDongService;
import com.ht.service.RoomService;
import com.opensymphony.xwork2.ActionSupport;


public class RoomAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private RoomService roomService;
	private TBuilding loudong;
	private THouse huxing;
	private List<TRoom> roomlist;
	private Logger logger = Logger.getLogger(LouPanAction.class);
	private String id;
	private TRoom room;
	private LouDongService louDongService;
	private HouseService houseService;
	private List<TBuilding> loudonglist;
	private List<THouse> houselist;
	private TAgency tagency;
	public TAgency getTagency() {
		return tagency;
	}

	public void setTagency(TAgency tagency) {
		this.tagency = tagency;
	}

	public LouDongService getLouDongService() {
		return louDongService;
	}

	public void setLouDongService(LouDongService louDongService) {
		this.louDongService = louDongService;
	}

	public HouseService getHouseService() {
		return houseService;
	}

	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}

	public List<TBuilding> getLoudonglist() {
		return loudonglist;
	}

	public void setLoudonglist(List<TBuilding> loudonglist) {
		this.loudonglist = loudonglist;
	}

	public List<THouse> getHouselist() {
		return houselist;
	}

	public void setHouselist(List<THouse> houselist) {
		this.houselist = houselist;
	}

	public TRoom getRoom() {
		return room;
	}

	public void setRoom(TRoom room) {
		this.room = room;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TBuilding getLoudong() {
		return loudong;
	}

	public void setLoudong(TBuilding loudong) {
		this.loudong = loudong;
	}

	public THouse getHuxing() {
		return huxing;
	}

	public void setHuxing(THouse huxing) {
		this.huxing = huxing;
	}

	public List<TRoom> getRoomlist() {
		return roomlist;
	}

	public void setRoomlist(List<TRoom> roomlist) {
		this.roomlist = roomlist;
	}

	public RoomService getRoomService() {
		return roomService;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}
	
	public String pageroom() throws Exception{
		paginglist();
		return "pageroom";
	}
	public String deletemanyroom() throws Exception{
		String idstring[]= id.split(",");
		for(int i=0;i<idstring.length;i++){
			room = new TRoom();
			room.setIdString(idstring[i]);
			logger.info("Ip为："+request.getRemoteAddr()+"的用户正在删除多个房号,房号"+i+"编号为"+idstring[i]+"，当前时间为："+new Date());
			roomService.delete(room);
		}
		System.out.println(huxing.getIdString());
		paginglist();
		return "deletemanyroom";
	}
	public String deleteroom() throws Exception{
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在删除id为"+room.getIdString()+"房号的信息，当前时间为："+new Date().toLocaleString());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		room.setIdString(room.getIdString());
		roomService.delete(room);
		out.print("删除成功");
		return "deleteroom";
	}
	public String updateroomstatus() throws Exception{
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在更新id为"+room.getIdString()+"房号的状态，当前时间为："+new Date().toLocaleString());
		room.setIdString(room.getIdString());
		room.setSaleStatusInt(room.getSaleStatusInt());
		roomService.update(room);
		return "updateroomstatus";
		
	}
	public String ldhxlist() throws Exception{
		HttpSession session = request.getSession();
		tagency = (TAgency)session.getAttribute("tagency");
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在房号，执行修改房号初始化楼栋、户型列表操作的状态，当前时间为："+new Date().toLocaleString());
		loudonglist = louDongService.loudonglist("jxsidString", tagency.getIdString());
		return "ldhxlist";
	}
	public String gethouselist() throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		houselist = houseService.findhouse("buildidString", loudong.getIdString());
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在通过"+loudong.getIdString()+"房号得到户型列表操作的状态，当前时间为："+new Date().toLocaleString());
		out.print(JSON.toJSONString(houselist));
		return null;
	}
	public String showroom() throws Exception{
		room = roomService.queryById(room.getIdString());
		huxing = room.getHuxing();
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在单个查询"+room.getIdString()+"房号资料，当前时间为："+new Date().toLocaleString());
		return "showroom";
	}
	public String addroom() throws Exception{
		room.setBuildingIdString(room.getBuildingIdString());
		room.setHouseIdString(huxing.getIdString());
		room.setSaleStatusInt(0);
		roomService.add(room);
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在新增一个房号，当前时间为："+new Date().toLocaleString());
		paginglist();
		return "addroom";
	}
	public String updateroom() throws Exception{
		room = roomService.queryById(room.getIdString());
		huxing = room.getHuxing();
		HttpSession session = request.getSession();
		tagency = (TAgency)session.getAttribute("tagency");
		loudonglist = louDongService.loudonglist("jxsidString", tagency.getIdString());
		houselist = houseService.findhouse("buildidString", room.getBuildingIdString());
		logger.info("Ip为："+request.getRemoteAddr()+"的用户正在更新"+room.getIdString()+"房号，当前时间为："+new Date().toLocaleString());
		return "updateroom";
	}
	public void paginglist() throws Exception {
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(10);
		page.setPagebarsum(roomService.count("houseIdString",huxing.getIdString()));
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
		DetachedCriteria dc = DetachedCriteria.forClass(TRoom.class);
		dc.add(Restrictions.eq("houseIdString", huxing .getIdString()));
		roomlist = roomService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
		request.setAttribute("pager", page);
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}

}
