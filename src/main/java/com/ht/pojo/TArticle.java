package com.ht.pojo;

import java.util.Date;

public class TArticle implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String idString;
	private String titleString;
	private String abstractsString;
	private String contentString;
	private String logoString;
	private Date createdTime;
	private Integer statusInt;
	private String typeInt;
	private String jxsidString;
	private String publicusernameString;
	public String manageridString;
	private String contenturlString;
	public String getContenturlString() {
		return contenturlString;
	}
	public void setContenturlString(String contenturlString) {
		this.contenturlString = contenturlString;
	}
	private TManager manager;
	public TManager getManager() {
		return manager;
	}
	public void setManager(TManager manager) {
		this.manager = manager;
	}
	public String getManageridString() {
		return manageridString;
	}
	public void setManageridString(String manageridString) {
		this.manageridString = manageridString;
	}
	public String getPublicusernameString() {
		return publicusernameString;
	}
	public void setPublicusernameString(String publicusernameString) {
		this.publicusernameString = publicusernameString;
	}
	private TArticleType tArticleType;
	public TArticleType gettArticleType() {
		return tArticleType;
	}
	public void settArticleType(TArticleType tArticleType) {
		this.tArticleType = tArticleType;
	}
	public String getTypeInt() {
		return typeInt;
	}
	public void setTypeInt(String typeInt) {
		this.typeInt = typeInt;
	}
	public String getJxsidString() {
		return jxsidString;
	}
	public void setJxsidString(String jxsidString) {
		this.jxsidString = jxsidString;
	}
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public String getTitleString() {
		return titleString;
	}
	public void setTitleString(String titleString) {
		this.titleString = titleString;
	}
	public String getAbstractsString() {
		return abstractsString;
	}
	public void setAbstractsString(String abstractsString) {
		this.abstractsString = abstractsString;
	}
	public String getContentString() {
		return contentString;
	}
	public void setContentString(String contentString) {
		this.contentString = contentString;
	}
	public String getLogoString() {
		return logoString;
	}
	public void setLogoString(String logoString) {
		this.logoString = logoString;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Integer getStatusInt() {
		return statusInt;
	}
	public void setStatusInt(Integer statusInt) {
		this.statusInt = statusInt;
	}


}