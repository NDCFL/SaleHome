package com.ht.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.ht.pojo.PagingBean;
import com.ht.pojo.TActivity;
import com.ht.pojo.TAgency;
import com.ht.pojo.TArticle;
import com.ht.pojo.TBuilding;
import com.ht.pojo.TBuildings;
import com.ht.pojo.TBuildingsImg;
import com.ht.pojo.TComment;
import com.ht.pojo.TCustomer;
import com.ht.pojo.TEmployee;
import com.ht.pojo.THistory;
import com.ht.pojo.THouse;
import com.ht.pojo.TRoom;
import com.ht.pojo.TUser;
import com.ht.service.ActivityService;
import com.ht.service.ArticleService;
import com.ht.service.CommentService;
import com.ht.service.EmployeeService;
import com.ht.service.HistoryService;
import com.ht.service.HouseService;
import com.ht.service.LikeService;
import com.ht.service.LouDongService;
import com.ht.service.LouPanImgService;
import com.ht.service.LouPanService;
import com.ht.service.RoomService;
import com.opensymphony.xwork2.ActionSupport;

public class FaceMainAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<TArticle> articlelist;
	private ArticleService  articleService;
	private List<TBuildings> loupanlist;
	private TBuildings loupan;
	private TBuilding loudong;
	private List<TBuilding> loudonglist;
	private LouDongService louDongService;
	private THouse house;
	private List<THouse> houselist;
	private HouseService houseService;
	private TRoom room;
	private List<TRoom> roomlist;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private int size=0;
	private LikeService likeService;
	private String id;
	private HistoryService historyService;
	private THistory history;
	private RoomService roomService;
	private CommentService commentService;
	private List<TComment> commentlist;
	private TAgency tagency;
	private List<TEmployee> employeelist;
	private EmployeeService employeeService;
	private List<TActivity> activitylist;
	private ActivityService activityService;
	private List<TBuildingsImg> loupanimglist;
	private LouPanImgService louPanImgService;
	

	public List<TBuildingsImg> getLoupanimglist() {
		return loupanimglist;
	}

	public void setLoupanimglist(List<TBuildingsImg> loupanimglist) {
		this.loupanimglist = loupanimglist;
	}

	public LouPanImgService getLouPanImgService() {
		return louPanImgService;
	}

	public void setLouPanImgService(LouPanImgService louPanImgService) {
		this.louPanImgService = louPanImgService;
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

	public List<TEmployee> getEmployeelist() {
		return employeelist;
	}

	public void setEmployeelist(List<TEmployee> employeelist) {
		this.employeelist = employeelist;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public TAgency getTagency() {
		return tagency;
	}

	public void setTagency(TAgency tagency) {
		this.tagency = tagency;
	}

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public List<TComment> getCommentlist() {
		return commentlist;
	}

	public void setCommentlist(List<TComment> commentlist) {
		this.commentlist = commentlist;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public LikeService getLikeService() {
		return likeService;
	}

	public void setLikeService(LikeService likeService) {
		this.likeService = likeService;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LouDongService getLouDongService() {
		return louDongService;
	}

	public void setLouDongService(LouDongService louDongService) {
		this.louDongService = louDongService;
	}

	public List<THouse> getHouselist() {
		return houselist;
	}

	public void setHouselist(List<THouse> houselist) {
		this.houselist = houselist;
	}

	public List<TRoom> getRoomlist() {
		return roomlist;
	}

	public void setRoomlist(List<TRoom> roomlist) {
		this.roomlist = roomlist;
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

	public TRoom getRoom() {
		return room;
	}

	public void setRoom(TRoom room) {
		this.room = room;
	}

	public RoomService getRoomService() {
		return roomService;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
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

	public LouPanService getLouPanService() {
		return louPanService;
	}

	public void setLouPanService(LouPanService louPanService) {
		this.louPanService = louPanService;
	}

	private LouPanService louPanService;
	public List<TArticle> getArticlelist() {
		return articlelist;
	}

	public void setArticlelist(List<TArticle> articlelist) {
		this.articlelist = articlelist;
	}

	
	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public String articlelist() throws Exception{
		articlelist = articleService.facetaricle();
		DetachedCriteria dc = DetachedCriteria.forClass(TBuildings.class);
		dc.addOrder(Order.desc("createdTime"));
		dc.add(Restrictions.eq("statusInt", 0));
		loupanlist = louPanService.pagelist(dc, 0, 10);
		DetachedCriteria dc1 = DetachedCriteria.forClass(TActivity.class);
		dc1.add(Restrictions.eq("statusInt", 0));
		dc1.addOrder(Order.desc("startTime"));
		activitylist = activityService.pagelist(dc1, 0, 2);
		return "articlelist";
	}
	public String facemaininfo() throws Exception{
		loupan = louPanService.queryById(loupan.getIdString());
		DetachedCriteria dc = DetachedCriteria.forClass(TBuilding.class);
		dc.add(Restrictions.eq("statusInt",0));
		dc.add(Restrictions.eq("buildingsId", loupan.getIdString()));
		dc.addOrder(Order.desc("createdTimeString"));
		loudonglist = louDongService.pagelist(dc, 0, 4);
		DetachedCriteria dc1 = DetachedCriteria.forClass(TBuildings.class);
		dc1.add(Restrictions.eq("statusInt", 0));
		dc1.addOrder(Order.desc("createdTime"));
		loupanlist = louPanService.pagelist(dc1, 0, 100);
		DetachedCriteria dc2 = DetachedCriteria.forClass(THouse.class);
		dc2.add(Restrictions.eq("jxsidString",loupan.getTagency().getIdString()));
		dc2.addOrder(Order.desc("createdTime"));
		houselist = houseService.pagelist(dc2, 0, 5);
		HttpSession session = request.getSession();
		TUser user = (TUser)session.getAttribute("user");
		if(user==null){
		}else if(user!=null){
			history = new THistory();
			history.setBuildingsIdString(loupan.getIdString());
			history.setCreatedTime(new Date());
			history.setUserIdString(user.getIdString());
			history.setIpString(request.getRemoteAddr());
			historyService.add(history);
		}
		try {
			size = likeService.count("buildingsIdString",loupan.getIdString());
			
		} catch (Exception e) {
			size=0;
		}
		DetachedCriteria dc3 = DetachedCriteria.forClass(TComment.class);
		dc3.add(Restrictions.eq("buildingsIdString",loupan.getIdString()));
		dc3.addOrder(Order.desc("commentTime"));
		commentlist = commentService.pagelist(dc3, 0, 100);
		DetachedCriteria dc4 = DetachedCriteria.forClass(TActivity.class);
		dc4.add(Restrictions.eq("statusInt", 0));
		dc4.addOrder(Order.desc("startTime"));
		activitylist = activityService.pagelist(dc4, 0, 2);
		articlelist = articleService.facetaricle();
		DetachedCriteria dc5 = DetachedCriteria.forClass(TBuildingsImg.class);
		dc5.add(Restrictions.eq("buildingsIdString", loupan.getIdString()));
		dc5.addOrder(Order.desc("createdTime"));
		loupanimglist = louPanImgService.pagelist(dc5, 0, 100);
		request.setAttribute("num", loupanimglist.size());
		return "facemaininfo";
	}
	public String houselist() throws Exception{
		int num = houseService.count("jxsidString",id);
		DetachedCriteria dc2 = DetachedCriteria.forClass(THouse.class);
		dc2.add(Restrictions.eq("jxsidString",id));
		dc2.add(Restrictions.eq("statusInt",0));
		dc2.addOrder(Order.desc("createdTime"));
		houselist = houseService.pagelist(dc2, 0, num);
		articlelist = articleService.facetaricle();
		DetachedCriteria dc4 = DetachedCriteria.forClass(TActivity.class);
		dc4.add(Restrictions.eq("statusInt", 0));
		dc4.addOrder(Order.desc("startTime"));
		activitylist = activityService.pagelist(dc4, 0, 2);
		request.setAttribute("num", houselist.size());
		return "houselist";
	}
	public String bestloupan() throws Exception{
		articlelist = articleService.facetaricle();
		DetachedCriteria dc4 = DetachedCriteria.forClass(TActivity.class);
		dc4.add(Restrictions.eq("statusInt", 0));
		dc4.addOrder(Order.desc("startTime"));
		activitylist = activityService.pagelist(dc4, 0, 2);
		paginglist();
		return "bestloupan";
	}
	public String othersloupan() throws Exception{
		articlelist = articleService.facetaricle();
		DetachedCriteria dc4 = DetachedCriteria.forClass(TActivity.class);
		dc4.add(Restrictions.eq("statusInt", 0));
		dc4.addOrder(Order.desc("startTime"));
		activitylist = activityService.pagelist(dc4, 0, 2);
		likepage();
		return "othersloupan";
		
	}
	public String manyarticle() throws Exception{
		DetachedCriteria dc4 = DetachedCriteria.forClass(TActivity.class);
		dc4.add(Restrictions.eq("statusInt", 0));
		dc4.addOrder(Order.desc("startTime"));
		activitylist = activityService.pagelist(dc4, 0, 2);
		articlelists();
		return "manyarticle";
	}
	public String houseinfo() throws Exception{
		house = houseService.queryById(house.getIdString());
		DetachedCriteria dc = DetachedCriteria.forClass(TRoom.class);
		dc.add(Restrictions.eq("houseIdString",house.getIdString()));
		dc.addOrder(Order.desc("createdTime"));
		try {
			roomlist = roomService.pagelist(dc, 0, 5);
			request.setAttribute("num", roomlist.size());
		} catch (Exception e) {
			
		}
		DetachedCriteria dc1 = DetachedCriteria.forClass(TBuildings.class);
		dc1.add(Restrictions.eq("statusInt", 0));
		dc1.addOrder(Order.desc("createdTime"));
		loupanlist = louPanService.pagelist(dc1, 0, 10);
		employeelist = employeeService.empList("angencyIdString", loupan.getJxsidString());
		DetachedCriteria dc4 = DetachedCriteria.forClass(TActivity.class);
		dc4.add(Restrictions.eq("statusInt", 0));
		dc4.addOrder(Order.desc("startTime"));
		activitylist = activityService.pagelist(dc4, 0, 2);
		return "houseinfo";
	}
	public String findloupan(){
		if(loupan.getNameString()==null){
			loupanlist = louPanService.loupanlist();
		}else{
			loupanlist = louPanService.likebuildings("t.addressString","%"+loupan.getNameString()+"%");
		}
		articlelist = articleService.facetaricle();
		DetachedCriteria dc4 = DetachedCriteria.forClass(TActivity.class);
		dc4.add(Restrictions.eq("statusInt", 0));
		dc4.addOrder(Order.desc("startTime"));
		activitylist = activityService.pagelist(dc4, 0, 2);
		request.setAttribute("num", loupanlist.size());
		return "findloupan";
	}
	public String buyhouseliucheng(){
		articlelist = articleService.facetaricle();
		DetachedCriteria dc4 = DetachedCriteria.forClass(TActivity.class);
		dc4.add(Restrictions.eq("statusInt", 0));
		dc4.addOrder(Order.desc("startTime"));
		activitylist = activityService.pagelist(dc4, 0, 2);
		return "buyhouseliucheng";
	}
	public String buyhouseliuchengtwo(){
		articlelist = articleService.facetaricle();
		DetachedCriteria dc4 = DetachedCriteria.forClass(TActivity.class);
		dc4.add(Restrictions.eq("statusInt", 0));
		dc4.addOrder(Order.desc("startTime"));
		activitylist = activityService.pagelist(dc4, 0, 2);
		return "buyhouseliuchengtwo";
	}
	public String page() throws Exception{
		articlelist = articleService.facetaricle();
		DetachedCriteria dc4 = DetachedCriteria.forClass(TActivity.class);
		dc4.addOrder(Order.desc("startTime"));
		activitylist = activityService.pagelist(dc4, 0, 2);
		return "page";
	}
	public void paginglist() throws Exception {
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(16);
		page.setPagebarsum(louPanService.count());
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
		DetachedCriteria dc = DetachedCriteria.forClass(TBuildings.class);
		dc.add(Restrictions.eq("statusInt", 0));
		dc.addOrder(Order.desc("createdTime"));
		loupanlist = louPanService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
		request.setAttribute("pager", page);
	}
	public void likepage() throws Exception {
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(16);
		page.setPagebarsum(louPanService.likecount("t.addressString", "%"+loupan.getNameString()+"%"));
		request.setAttribute("name", loupan.getNameString());
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
		loupanlist = louPanService.likebuildings("t.addressString","%"+loupan.getNameString()+"%",page.getStarlocal(),page.getPagebarsize());
		request.setAttribute("pager", page);
		request.setAttribute("num", loupanlist.size());
	}
	public void articlelists() throws Exception {
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(14);
		page.setPagebarsum(articleService.articlesize());
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
		DetachedCriteria dc = DetachedCriteria.forClass(TArticle.class);
		dc.addOrder(Order.desc("createdTime"));
		articlelist = articleService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
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
