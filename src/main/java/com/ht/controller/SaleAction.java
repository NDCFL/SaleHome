package com.ht.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.alibaba.fastjson.JSON;
import com.ht.pojo.PagingBean;
import com.ht.pojo.TAppointment;
import com.ht.pojo.TBaobiao;
import com.ht.pojo.TCustomer;
import com.ht.pojo.TEmployee;
import com.ht.pojo.TMission;
import com.ht.pojo.TRoom;
import com.ht.pojo.TSale;
import com.ht.pojo.TUserprize;
import com.ht.service.AppointmentService;
import com.ht.service.CustomerService;
import com.ht.service.MissionService;
import com.ht.service.RoomService;
import com.ht.service.SaleService;
import com.ht.service.UserPrizeService;
import com.opensymphony.xwork2.ActionSupport;

public class SaleAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TSale sale;
	public List<TSale> salelist;
	private SaleService saleService;
	private TCustomer customer;
	private TEmployee employee;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String id;
	private List<TCustomer> customerlist;
	private CustomerService customerService;
	private List<TRoom> roomlist;
	private RoomService roomService;
	private MissionService missionService;
	private TMission mission;
	private TUserprize userprize;
	private UserPrizeService userPrizeService;
	private TRoom room;
	private File file;
	private AppointmentService appointmentService;
	public AppointmentService getAppointmentService() {
		return appointmentService;
	}
	public void setAppointmentService(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
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
	private String fileFileName;
	public TRoom getRoom() {
		return room;
	}
	public void setRoom(TRoom room) {
		this.room = room;
	}
	public TUserprize getUserprize() {
		return userprize;
	}
	public void setUserprize(TUserprize userprize) {
		this.userprize = userprize;
	}
	public UserPrizeService getUserPrizeService() {
		return userPrizeService;
	}
	public void setUserPrizeService(UserPrizeService userPrizeService) {
		this.userPrizeService = userPrizeService;
	}
	public TMission getMission() {
		return mission;
	}
	public void setMission(TMission mission) {
		this.mission = mission;
	}
	public MissionService getMissionService() {
		return missionService;
	}
	public void setMissionService(MissionService missionService) {
		this.missionService = missionService;
	}
	public List<TCustomer> getCustomerlist() {
		return customerlist;
	}
	public void setCustomerlist(List<TCustomer> customerlist) {
		this.customerlist = customerlist;
	}
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TSale getSale() {
		return sale;
	}
	public void setSale(TSale sale) {
		this.sale = sale;
	}
	public List<TSale> getSalelist() {
		return salelist;
	}
	public void setSalelist(List<TSale> salelist) {
		this.salelist = salelist;
	}
	public SaleService getSaleService() {
		return saleService;
	}
	public void setSaleService(SaleService saleService) {
		this.saleService = saleService;
	}
	public TCustomer getCustomer() {
		return customer;
	}
	public void setCustomer(TCustomer customer) {
		this.customer = customer;
	}
	public TEmployee getEmployee() {
		return employee;
	}
	public void setEmployee(TEmployee employee) {
		this.employee = employee;
	}
	public String pagesale() throws Exception{
		paginglist();
		return "pagesale";
	}
	public String deletemanysale() throws Exception{
		String idstring[]= id.split(",");
		for(int i=0;i<idstring.length;i++){
			sale = new TSale();
			sale.setIdString(idstring[i]);
			saleService.delete(sale);
		}
		paginglist();
		return "deletemanysale";
	}
	public String deletesale() throws Exception{
		saleService.delete(sale);
		return "deletesale";
	}
	public String initaddsale() throws Exception{
		HttpSession session = request.getSession();
		TEmployee employee = (TEmployee)session.getAttribute("employee");
		roomlist  = roomService.roomlist();
		customerlist = customerService.findcustor("employeeId", employee.getIdString());
		return "initaddsale";
	}
	public String updatesalestatus() throws Exception{
		saleService.update(sale);
		return "updatesalestatus";
	}
	public String saveaddsale() throws Exception{
		HttpSession session = request.getSession();
		TEmployee employee = (TEmployee)session.getAttribute("employee");
		sale.setEmpIdString(employee.getIdString());
		sale.setCreatedTime(new Date());
		sale.setStatusInt(0);
		sale.setSaleHomeStatus(0);
		sale.setReason("请求审核");
		saleService.add(sale);
		paginglist();
		return "saveaddsale";
	}
	public String showsale() throws Exception{
		sale = saleService.queryById(sale.getIdString());
		return "showsale";
	}
	public String updatesale() throws Exception{
		saleService.shenhe(sale);
		if(sale.getSaleHomeStatus()==1){
			sale = saleService.queryById(sale.getIdString());
			mission = new TMission();
			mission.setEmpIdString(sale.getEmpIdString());
			missionService.updatelastquentity(mission);
			userprize = new TUserprize();
			userprize.setCreateTime(new Date());
			userprize.setPrize(sale.getDiscountDouble()*sale.getTotalCostDouble()/1000);
			userprize.setUserIdString(sale.getCustomerIdString());
			userprize.setEmployeeidString(sale.getEmpIdString());
			userPrizeService.add(userprize);
			customer = new TCustomer();
			customer.setIdString(sale.getCustomerIdString());
			customer.setCustomerTypeInt(2);
			customerService.buyhouse(customer);
			room = new TRoom();
			room.setSaleStatusInt(1);
			room.setIdString(sale.getRoomIdString());
			roomService.update(room);
//			TAppointment appointment = new TAppointment();
//			appointment
//			appointmentService.update(t);
		}
		pagingsalelist();
		return "updatesale";
	}
	public String shenhesale() throws Exception{
		sale = saleService.queryById(sale.getIdString());
		return "shenhesale";
	}
	public String upfact() throws Exception{
		String filepath = request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		String newname = getFileName(fileFileName);
		customer.setContractString("upfile/"+newname);
		FileUtils.copyFile(file, new File(filepath,newname));
		customerService.upfact(customer);
		paginglist();
		return "upfact";
	}
	private synchronized String getFileName(String filename) {
		int position = filename.lastIndexOf(".");
		String ext = filename.substring(position);
		return System.nanoTime() + ext;
	}
	public String shenhelist() throws Exception{
		pagingsalelist();
		return "shenhelist";
	}
	public String baobiao() throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<TBaobiao> l = new ArrayList<TBaobiao>();
		@SuppressWarnings("rawtypes")
		List list = saleService.baobiaolist();
		for(int i=0;i<list.size();i++){
			TBaobiao baobiao = new TBaobiao();
			double d[]=new double[12];
			Object [] object = (Object [])list.get(i);
			for(int j=0;j<12;j++){
				d[j]=Double.parseDouble(object[j+1].toString());
			}
			baobiao.setName(object[0].toString());
			baobiao.setData(d);
			l.add(baobiao);
		}
		out.print(JSON.toJSONString(l));
		return null;
	}
	public void paginglist() throws Exception {
		HttpSession session = request.getSession();
 		TEmployee t = (TEmployee)session.getAttribute("employee");
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(10);
		page.setPagebarsum(saleService.count("empIdString",t.getIdString()));
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
		DetachedCriteria dc = DetachedCriteria.forClass(TSale.class);
		dc.add(Restrictions.eq("empIdString",t.getIdString()));
		salelist = saleService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
		request.setAttribute("pager", page);
	}
	public void pagingsalelist() throws Exception {
		HttpSession session = request.getSession();
 		TEmployee t = (TEmployee)session.getAttribute("employee");
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(10);
		page.setPagebarsum(saleService.count());
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
		DetachedCriteria dc = DetachedCriteria.forClass(TSale.class);
		dc.addOrder(Order.desc("createdTime"));
		salelist = saleService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
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
