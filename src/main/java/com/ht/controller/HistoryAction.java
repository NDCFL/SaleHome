package com.ht.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.alibaba.fastjson.JSON;
import com.ht.pojo.PagingBean;
import com.ht.pojo.TBaobiao;
import com.ht.pojo.THistory;
import com.ht.pojo.TUser;
import com.ht.service.HistoryService;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane.ScalableIconUIResource;

public class HistoryAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private List<THistory> historylist;
	private HistoryService historyService;
	private THistory history;
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
	public List<THistory> getHistorylist() {
		return historylist;
	}
	public void setHistorylist(List<THistory> historylist) {
		this.historylist = historylist;
	}
	public HistoryService getHistoryService() {
		return historyService;
	}
	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}
	public THistory getHistory() {
		return history;
	}
	public void setHistory(THistory history) {
		this.history = history;
	}
	public String pagehistory() throws Exception{
		paginglist();	
		return "pagehistory";
	}
	public String deletehistory() throws Exception{
		historyService.delete(history);
		return "deletehistory";
	}
	public String baobiao() throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<TBaobiao> l = new ArrayList<TBaobiao>();
		@SuppressWarnings("rawtypes")
		List list = historyService.historylist();
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
	public String deletemanyhistory() throws Exception{
		String idstring[]= id.split(",");
		for(int i=0;i<idstring.length;i++){
			history = new THistory();
			history.setIdString(idstring[i]);
			historyService.delete(history);
		}
		paginglist();
		return "deletemanyhistory";
	}
	public void paginglist() throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//实例化javabean，取参数
		HttpSession session = request.getSession();
		TUser user = (TUser)session.getAttribute("user");
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(10);
		if(startTime==null ||endTime==null || startTime.equals("") || endTime.equals("")){
			page.setPagebarsum(historyService.count("userIdString",user.getIdString()));
		}else{
			DetachedCriteria dc = DetachedCriteria.forClass(THistory.class);
			dc.add(Restrictions.eq("userIdString",user.getIdString()));
			page.setPagebarsum(historyService.pagecount(dc.add(Restrictions.between("createdTime", df.parse(startTime+" 00:00:00"), df.parse(endTime+" 23:59:59")))));
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
		DetachedCriteria dc = DetachedCriteria.forClass(THistory.class);
		if(startTime==null || endTime==null || startTime.equals("") || endTime.equals("")){
			dc.add(Restrictions.eq("userIdString",user.getIdString()));
			dc.addOrder(Order.desc("createdTime"));
		}else{
			dc.add(Restrictions.eq("userIdString",user.getIdString()));
			dc.add(Restrictions.between("createdTime",df.parse(startTime+" 00:00:00"), df.parse(endTime+" 23:59:59")));
			dc.addOrder(Order.desc("createdTime"));
		}
		System.out.println(page.getStarlocal()+"=====");
		historylist = historyService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
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
