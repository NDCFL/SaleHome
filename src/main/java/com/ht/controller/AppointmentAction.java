package com.ht.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.alibaba.fastjson.JSON;
import com.ht.API.SendEmail;
import com.ht.pojo.PagingBean;
import com.ht.pojo.TAgency;
import com.ht.pojo.TAppointment;
import com.ht.pojo.TCustomer;
import com.ht.pojo.TEmployee;
import com.ht.pojo.THouse;
import com.ht.pojo.TSale;
import com.ht.pojo.TUser;
import com.ht.service.AppointmentService;
import com.ht.service.CustomerService;
import com.ht.service.EmployeeService;
import com.ht.service.HouseService;
import com.ht.service.SaleService;
import com.ht.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class AppointmentAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private AppointmentService appointmentService;
	private TAppointment appointment;
	private List<TAppointment> appointmentlist;
	private TEmployee employee;
	private EmployeeService employeeService;
	private String id;
	private String username;
	private TUser user;
	private UserService userService;
	private THouse house;
	private HouseService houseService;
	private TSale sale;
	private SaleService saleService;
	private TCustomer customer;
	private CustomerService customerService;
	public TCustomer getCustomer() {
		return customer;
	}
	public void setCustomer(TCustomer customer) {
		this.customer = customer;
	}
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	public TSale getSale() {
		return sale;
	}
	public void setSale(TSale sale) {
		this.sale = sale;
	}
	public SaleService getSaleService() {
		return saleService;
	}
	public void setSaleService(SaleService saleService) {
		this.saleService = saleService;
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
	public THouse getHouse() {
		return house;
	}
	public void setHouse(THouse house) {
		this.house = house;
	}
	public HouseService getHouseService() {
		return houseService;
	}
	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	private int type;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TEmployee getEmployee() {
		return employee;
	}
	public void setEmployee(TEmployee employee) {
		this.employee = employee;
	}
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public AppointmentService getAppointmentService() {
		return appointmentService;
	}
	public void setAppointmentService(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	public TAppointment getAppointment() {
		return appointment;
	}
	public void setAppointment(TAppointment appointment) {
		this.appointment = appointment;
	}
	public List<TAppointment> getAppointmentlist() {
		return appointmentlist;
	}
	public void setAppointmentlist(List<TAppointment> appointmentlist) {
		this.appointmentlist = appointmentlist;
	}
	public String pageappointment() throws Exception{
		paginglist();
		return "pageappointment";
	}
	public String pagejxsappointment() throws Exception{
		pagingjxslist();
		return "pageappointment";
	}
	public String pageuserappointment() throws Exception{
		paginguserlist();
		return "pageuserappointment";
	}
	public String updateappointment() throws Exception{
		appointmentService.update(appointment);
		appointment = appointmentService.queryById(appointment.getIdString());
		if(appointment.getAppStatusInt()==2){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
			String d= df.format(appointment.getArriveTime());
			String receiveEmail = appointment.getUserIdString();
	        String receiveNick="陈飞龙";
	        String subject="【桃源盛景】";
	        String contents="【桃源盛景】尊敬的"+username+"客户你好，你和"+appointment.getEmpIdString()+"销售顾问预约了在"+d+"时间去看"+appointment.getHouseIdString()+",希望你准时看房，如有特殊情况可以取消预约，或联系销售顾问，在此温馨提示：出行注意安全，看房愉快！谢谢！";
	        SendEmail.sendMail(receiveEmail, receiveNick, subject, contents);
		}
		paginglist();
		return "updateappointment";
	}
	public String updateuserappointment() throws Exception{
		if(appointment.getUserIdString()!=null){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
			String d= df.format(appointment.getArriveTime());
			String receiveEmail = appointment.getUserIdString();
			String receiveNick="陈飞龙";
	        String subject="【桃源盛景】";
	        String contents="【桃源盛景】尊敬的"+appointment.getEmpIdString()+"销售顾问你好，你的客户"+username+"确认了预约时间，预约的时间为"+d+",请务必要准时。如有特殊情况可以申请更换顾问，但须提前通知客户。在此温馨提示：出行注意安全,顺利出单！谢谢！";
	        SendEmail.sendMail(receiveEmail, receiveNick, subject, contents);
	        System.out.println("发送成功！");
		}
		appointmentService.updateuserstatus(appointment);
		paginguserlist();
		return "updateuserappointment";
	}
	public String deleteappointment() throws Exception{
		appointmentService.delete(appointment);
		paginglist();
		return "deleteappointment";
	}
	public String deletemanyappointment() throws Exception{
		String idstring[]= id.split(",");
		for(int i=0;i<idstring.length;i++){
			appointment = new TAppointment();
			appointment.setIdString(idstring[i]);
			appointmentService.delete(appointment);
		}
		if(type==0){
			pagingjxslist();
		}else{
			paginglist();
		}
		return "deletemanyappointment";
	}
	public String updateappointmentstatus() throws Exception{
		appointmentService.updatestatus(appointment);
		paginglist();
		return "updateappointmentstatus";
	}
	public String addappointment() throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		TUser user = (TUser)session.getAttribute("user");
		if(user==null){
			out.print("0");
			return null;
		}else{
			int count = appointmentService.count("userIdString", user.getIdString());
			if(count>=1){
				out.print("3");
				return null;
			}
			try {
				employee = employeeService.empList("nameString", appointment.getEmpIdString()).get(0);
				appointment.setEmpIdString(employee.getIdString());
				appointment.setUserIdString(user.getIdString());
				appointment.setAppStatusInt(0);
				appointment.setCreatedTime(new Date());
				appointment.setStatus(0);
				appointment.setReasonString("预约看心仪的户型");
				appointmentService.add(appointment);
				out.print("2");
				return null;
			} catch (Exception e) {
				out.print("1");
				return null;
			}
		}
	}
	public String buyhouse() throws Exception{
		pagingbuyhouselist();
		return "buyhouse";
	}
	public String querenbuy() throws Exception{
		appointment = appointmentService.queryById(appointment.getIdString());
		customer.setBirthday(appointment.getUser().getBirthday());
		customer.setCreatedTime(new Date());
		customer.setCustomerTypeInt(1);
		customer.setEmailString(appointment.getUser().getEmailString());
		customer.setEmployeeId(appointment.getEmpIdString());
		customer.setGenderString(appointment.getUser().getGenderString());
		customer.setHeadiconString(appointment.getUser().getHeadiconString());
		customer.setJxsidString(appointment.getEmployee().getAngencyIdString());
		customer.setNameString(appointment.getUser().getNameString());
		customer.setPhoneString(appointment.getUser().getPhoneString());
		customer.setStatusInt(0);
		customerService.add(customer);
		String receiveEmail = appointment.getUser().getEmailString();
		String receiveNick="陈飞龙";
        String subject="【桃源盛景】";
        String contents="【桃源盛景】尊敬的"+appointment.getUser().getNameString()+"客户你好，你在"+new Date().toLocaleString()+"在桃源盛景平台确认购买"+appointment.getHouse().getTbuilding().getBuildings().getNameString()+"楼盘"+appointment.getHouse().getTbuilding().getNameString()+"楼栋"+appointment.getHouse().getNameString()+"户型,一分钟后销售顾问会主动和你联系，商量交接时间，并签订合同，请耐心等待，顾问联系方式（"+appointment.getEmployee().getPhoneString()+"）。在此温馨提示：出行注意安全！谢谢！";
        SendEmail.sendMail(receiveEmail, receiveNick, subject, contents);
        String receiveEmail1 = appointment.getEmployee().getEmailString();
		String receiveNick1="陈飞龙";
        String subject1="【桃源盛景】";
        String contents1="【桃源盛景】尊敬的"+appointment.getEmployee().getNameString()+"销售顾问你好，你的客户"+appointment.getEmployee().getNameString()+"在"+new Date().toLocaleString()+"在桃源盛景平台确认购买"+appointment.getHouse().getTbuilding().getBuildings().getNameString()+"楼盘"+appointment.getHouse().getTbuilding().getNameString()+"楼栋"+appointment.getHouse().getNameString()+"户型,请一分钟之内联系客户，商量交接时间，并签订合同，客户联系方式("+appointment.getUser().getPhoneString()+")。在此温馨提示：出行注意安全！谢谢！";
        SendEmail.sendMail(receiveEmail1, receiveNick1, subject1, contents1);
        pagingbuyhouselist();
		return "querenbuy";
	}
	public void pagingjxslist() throws Exception {
		HttpSession session = request.getSession();
 		TAgency t = (TAgency)session.getAttribute("tagency");
		PagingBean page = new PagingBean();
		page.setPagebarsize(10);
		page.setPagebarsum(appointmentService.count("jxsidString",t.getIdString()));
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
		DetachedCriteria dc = DetachedCriteria.forClass(TAppointment.class);
		dc.add(Restrictions.eq("jxsidString",t.getIdString()));
		appointmentlist = appointmentService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
		request.setAttribute("pager", page);
	}
	public void paginguserlist() throws Exception {
		HttpSession session = request.getSession();
 		TUser t = (TUser)session.getAttribute("user");
		PagingBean page = new PagingBean();
		page.setPagebarsize(4);
		page.setPagebarsum(appointmentService.count("userIdString",t.getIdString()));
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
			DetachedCriteria dc = DetachedCriteria.forClass(TAppointment.class);
			dc.add(Restrictions.eq("userIdString",t.getIdString()));
			appointmentlist = appointmentService.pagelist(dc,(page.getPagebarsum()-page.getPagebarsize()), page.getPagebarsize());
			page.setStarlocal(page.getPagebarsum()-page.getPagebarsize());
			request.setAttribute("pager", page);
			return;
		}else{
			DetachedCriteria dc = DetachedCriteria.forClass(TAppointment.class);
			dc.add(Restrictions.eq("userIdString",t.getIdString()));
			appointmentlist = appointmentService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
			request.setAttribute("pager", page);
		}
	}

	public void paginglist() throws Exception {
		HttpSession session = request.getSession();
 		TEmployee t = (TEmployee)session.getAttribute("employee");
		PagingBean page = new PagingBean();
		page.setPagebarsize(4);
		page.setPagebarsum(appointmentService.count("empIdString",t.getIdString()));
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
			DetachedCriteria dc = DetachedCriteria.forClass(TAppointment.class);
			dc.add(Restrictions.eq("empIdString",t.getIdString()));
			appointmentlist = appointmentService.pagelist(dc,(page.getPagebarsum()-page.getPagebarsize()), page.getPagebarsize());
			page.setStarlocal(page.getPagebarsum()-page.getPagebarsize());
			request.setAttribute("pager", page);
			return;
		}else{
			DetachedCriteria dc = DetachedCriteria.forClass(TAppointment.class);
			dc.add(Restrictions.eq("empIdString",t.getIdString()));
			appointmentlist = appointmentService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
			request.setAttribute("pager", page);
		}
	}
	public void pagingbuyhouselist() throws Exception {
		HttpSession session = request.getSession();
 		TUser t = (TUser)session.getAttribute("user");
		PagingBean page = new PagingBean();
		page.setPagebarsize(4);
		page.setPagebarsum(appointmentService.buyhousecount(t.getIdString(),2));
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
			DetachedCriteria dc = DetachedCriteria.forClass(TAppointment.class);
			dc.add(Restrictions.eq("userIdString",t.getIdString()));
			dc.add(Restrictions.eq("appStatusInt", 2));
			appointmentlist = appointmentService.pagelist(dc,(page.getPagebarsum()-page.getPagebarsize()), page.getPagebarsize());
			page.setStarlocal(page.getPagebarsum()-page.getPagebarsize());
			request.setAttribute("pager", page);
			return;
		}else{
			DetachedCriteria dc = DetachedCriteria.forClass(TAppointment.class);
			dc.add(Restrictions.eq("userIdString",t.getIdString()));
			dc.add(Restrictions.eq("appStatusInt", 2));
			appointmentlist = appointmentService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
			request.setAttribute("pager", page);
		}
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
