package com.ht.controller;

import java.io.File;
import java.io.FileOutputStream;
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

import com.ht.pojo.FileUpInfoVo;
import com.ht.pojo.PagingBean;
import com.ht.pojo.TAgency;
import com.ht.pojo.TArticle;
import com.ht.pojo.TArticleType;
import com.ht.service.ArticleService;
import com.ht.service.TArticleTypeService;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ArticleService articleService;
	private File file;
	private FileUpInfoVo fileupinfo;
	private TArticle article;
	private List<TArticle> articleslist;
	private TArticleTypeService tArticleTypeService;
	private List<TArticleType> typelist;
	private Logger logger = Logger.getLogger(Login_RegirestAction.class);
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TArticleTypeService gettArticleTypeService() {
		return tArticleTypeService;
	}
	public void settArticleTypeService(TArticleTypeService tArticleTypeService) {
		this.tArticleTypeService = tArticleTypeService;
	}
	public List<TArticleType> getTypelist() {
		return typelist;
	}
	public void setTypelist(List<TArticleType> typelist) {
		this.typelist = typelist;
	}
	public TArticle getArticle() {
		return article;
	}
	public List<TArticle> getArticleslist() {
		return articleslist;
	}
	public void setArticleslist(List<TArticle> articleslist) {
		this.articleslist = articleslist;
	}
	public void setArticle(TArticle article) {
		this.article = article;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public String upfile() throws Exception{
		HttpSession session = request.getSession();
		TAgency tagency = (TAgency)session.getAttribute("tagency");
		String filepath = request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		System.out.println(fileupinfo.getDocFileName());
		String newname = getFileName(fileupinfo.getDocFileName());
		article.setLogoString("upfile/"+newname);
		FileUtils.copyFile(fileupinfo.getDoc(), new File(filepath,newname));
		long filename = System.currentTimeMillis();
		String msgContentUrl="upfile/"+filename+".html";
		uploud(article.getContentString(), msgContentUrl);
		article.setCreatedTime(new Date());
		article.setStatusInt(0);
		article.setContenturlString(msgContentUrl);
		article.setJxsidString(tagency.getIdString());
		articleService.add(article);
		paginglist();
		return "upfile";
		
	}
	public FileUpInfoVo getFileupinfo() {
		return fileupinfo;
	}
	public void setFileupinfo(FileUpInfoVo fileupinfo) {
		this.fileupinfo = fileupinfo;
	}
	public String initaddarticle() throws Exception{
		DetachedCriteria dc = DetachedCriteria.forClass(TArticleType.class);
		typelist = tArticleTypeService.pagelist(dc, 0, tArticleTypeService.findtype().size());
		return "initaddarticle";
		
	}
	public String deletearticle() throws Exception{
		articleService.delete(article);
		return "deletearticle";
	}
	public String updatearticlestatus() throws Exception{
		articleService.updatearticlestatus(article);
		return "updatearticlestatus";
	}
	public String updatemanyarticle() throws Exception{
		String idstring[]= id.split(",");
		for(int i=0;i<idstring.length;i++){
			article = new TArticle();
			article.setIdString(idstring[i]);
			logger.info("Ip为："+request.getRemoteAddr()+"的用户正在删除多片资讯,资讯"+i+"编号为"+idstring[i]+"，当前时间为："+new Date().toLocaleString());
			articleService.delete(article);
		}
		paginglist1();
		return "updatemanyarticle";
	}
	public void uploud(String content,String filename){
		String PAGE_HEAD="<!DOCTYPE HTML><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body>";
		String PAGE_TAIL="</body></html>";
		content = PAGE_HEAD + content + PAGE_TAIL;
		String savePath = request.getRealPath("/") + filename;
		File file = new File(savePath);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			fos.write(content.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String pagearticle() throws Exception{
		paginglist();
		return "pagearticle";
	}
	public String allarticlelist() throws Exception{
		paginglist1();
		return "allarticlelist";
		
	}
	public String initupdatearticle() throws Exception{
		article = articleService.queryById(article.getIdString());
		DetachedCriteria dc = DetachedCriteria.forClass(TArticleType.class);
		typelist = tArticleTypeService.pagelist(dc, 0, tArticleTypeService.findtype().size());
		return "initupdatearticle";
	}
	public String updasavetearticle() throws Exception{
		String filepath = request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		if(fileupinfo==null){
			fileupinfo = new FileUpInfoVo();
			fileupinfo.setDocFileName(article.getLogoString());
		}else{
			String newname = getFileName(fileupinfo.getDocFileName());
			article.setLogoString("upfile/"+newname);
			FileUtils.copyFile(fileupinfo.getDoc(), new File(filepath,newname));
		}
		String PAGE_HEAD="<!DOCTYPE HTML><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body>";
		String PAGE_TAIL="</body></html>";
		String content = PAGE_HEAD + article.getContentString() + PAGE_TAIL;
		String savePath = request.getRealPath("/") +article.getContenturlString();
		File file = new File(savePath);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			fos.write(content.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(article.getContentString());
		articleService.update(article);
		paginglist();
		return "updasavetearticle";
	}
	public void paginglist1() throws Exception {
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(10);
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
		articleslist = articleService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
		request.setAttribute("pager", page);

	}
	public void paginglist() throws Exception {
		HttpSession session = request.getSession();
		TAgency tagency = (TAgency)session.getAttribute("tagency");
		//实例化javabean，取参数
		PagingBean page = new PagingBean();
		//总记录条数，计算总页数
		page.setPagebarsize(10);
		if(tagency==null){
			page.setPagebarsum(articleService.articlesize());
		}else{
			page.setPagebarsum(articleService.count("jxsidString",tagency.getIdString()));
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
		DetachedCriteria dc = DetachedCriteria.forClass(TArticle.class);
		if(tagency!=null){
			dc.add(Restrictions.eq("jxsidString",tagency.getIdString()));
		}
		articleslist = articleService.pagelist(dc, page.getStarlocal(), page.getPagebarsize());
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
	private synchronized String getFileName(String filename) {
		int position = filename.lastIndexOf(".");
		String ext = filename.substring(position);
		return System.nanoTime() + ext;
	}
	
}
