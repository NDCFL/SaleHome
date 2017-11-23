package com.ht.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ht.pojo.PagingBean;
import com.ht.pojo.TCustomer;
import com.ht.pojo.TEmployee;
import com.ht.pojo.TMission;
import com.ht.service.EmployeeService;
import com.ht.service.MissionService;
import com.opensymphony.xwork2.ActionSupport;

public class MissionAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	private HttpServletResponse response;
	private MissionService missionService;
	private TMission mission;
	private List<TMission> missionlist;
	private List<TEmployee> employeelist;
	private EmployeeService employeeService;
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public List<TEmployee> getEmployeelist() {
		return employeelist;
	}
	public void setEmployeelist(List<TEmployee> employeelist) {
		this.employeelist = employeelist;
	}
	public TMission getMission() {
		return mission;
	}
	public void setMission(TMission mission) {
		this.mission = mission;
	}
	public List<TMission> getMissionlist() {
		return missionlist;
	}
	public void setMissionlist(List<TMission> missionlist) {
		this.missionlist = missionlist;
	}
	public MissionService getMissionService() {
		return missionService;
	}
	public void setMissionService(MissionService missionService) {
		this.missionService = missionService;
	}
	public String pagemission() throws Exception{
		paginglist();
		return "pagemission";
	}
	public String initaddmission() throws Exception{
		HttpSession session = request.getSession();
		TEmployee employee = (TEmployee)session.getAttribute("employee");
		employeelist = employeeService.empList("angencyIdString",employee.getAngencyIdString());
		return "initaddmission";
	}
	public String addsavemission() throws Exception{ 
		HttpSession session = request.getSession();
		TEmployee employee = (TEmployee)session.getAttribute("employee");
		employeelist = employeeService.empList("angencyIdString",employee.getAngencyIdString());
		mission.setJxsidString(employee.getAngencyIdString());
		mission.setLastQuantityInt(0);
		missionService.add(mission);
		paginglist();
		return "addsavemission";
	}
	public String initupdatemission() throws Exception{
		HttpSession session = request.getSession();
		TEmployee employee = (TEmployee)session.getAttribute("employee");
		employeelist = employeeService.empList("angencyIdString",employee.getAngencyIdString());
		mission = missionService.queryById(mission.getIdString());
		return "initupdatemission";
	}
	public String updatesavemission() throws Exception{
		HttpSession session = request.getSession();
		TEmployee employee = (TEmployee)session.getAttribute("employee");
		mission.setJxsidString(employee.getAngencyIdString());
		missionService.add(mission);
		paginglist();
		return "updatesavemission";
	}
	public String deletemission() throws Exception{
		missionService.delete(mission);
		return "deletemission";
	}
	public String deletemanymission() throws Exception{
		String idstring[]= id.split(",");
		for(int i=0;i<idstring.length;i++){
			mission = new TMission();
			mission.setIdString(idstring[i]);
			missionService.delete(mission);
		}
		paginglist();
		return "deletemanymission";
	}
	public void paginglist() throws Exception {
		HttpSession session = request.getSession();
		TEmployee t = (TEmployee)session.getAttribute("employee");
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(10);
		page.setPagebarsum(missionService.count("jxsidString",t.getAngencyIdString()));
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
		DetachedCriteria dc = DetachedCriteria.forClass(TMission.class);
		dc.add(Restrictions.eq("jxsidString",t.getAngencyIdString()));
		missionlist = missionService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
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
