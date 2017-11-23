package com.ht.pojo;

import java.util.Date;

/**
 * TActivity entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TActivity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idString;
	private String titleString;
	private Date startTime;
	private Date endTime;
	private String addressString;
	private String contentString;
	private String logoString;
	private String buildingsIdString;
	private int statusInt;
	private String manageridString;
	private String jxsidString;
	private String urlString;
	
	public String getUrlString() {
		return urlString;
	}
	public void setUrlString(String urlString) {
		this.urlString = urlString;
	}
	private TBuildings loupan;
	private TAgency tagency;
	private TManager manager;
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
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getAddressString() {
		return addressString;
	}
	public void setAddressString(String addressString) {
		this.addressString = addressString;
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
	public String getBuildingsIdString() {
		return buildingsIdString;
	}
	public void setBuildingsIdString(String buildingsIdString) {
		this.buildingsIdString = buildingsIdString;
	}
	public String getJxsidString() {
		return jxsidString;
	}
	public void setJxsidString(String jxsidString) {
		this.jxsidString = jxsidString;
	}
	public TBuildings getLoupan() {
		return loupan;
	}
	public void setLoupan(TBuildings loupan) {
		this.loupan = loupan;
	}
	public TAgency getTagency() {
		return tagency;
	}
	public void setTagency(TAgency tagency) {
		this.tagency = tagency;
	}
	public TManager getManager() {
		return manager;
	}
	public void setManager(TManager manager) {
		this.manager = manager;
	}
	public int getStatusInt() {
		return statusInt;
	}
	public void setStatusInt(int statusInt) {
		this.statusInt = statusInt;
	}
	public String getManageridString() {
		return manageridString;
	}
	public void setManageridString(String manageridString) {
		this.manageridString = manageridString;
	}
}