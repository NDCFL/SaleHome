package com.ht.pojo;

import java.util.Date;

/**
 * TAds entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TAds implements java.io.Serializable {

	// Fields

	private String idString;
	private String titleString;
	private String contentString;
	private String logoString;
	private String adUrlString;
	private String showStatusString;
	private Integer showOrderInt;
	private Date createdTime;
	private Integer statusInt;

	// Constructors

	/** default constructor */
	public TAds() {
	}

	/** minimal constructor */
	public TAds(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public TAds(String idString, String titleString, String contentString,
			String logoString, String adUrlString, String showStatusString,
			Integer showOrderInt, Date createdTime, Integer statusInt) {
		this.idString = idString;
		this.titleString = titleString;
		this.contentString = contentString;
		this.logoString = logoString;
		this.adUrlString = adUrlString;
		this.showStatusString = showStatusString;
		this.showOrderInt = showOrderInt;
		this.createdTime = createdTime;
		this.statusInt = statusInt;
	}

	// Property accessors

	public String getIdString() {
		return this.idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public String getTitleString() {
		return this.titleString;
	}

	public void setTitleString(String titleString) {
		this.titleString = titleString;
	}

	public String getContentString() {
		return this.contentString;
	}

	public void setContentString(String contentString) {
		this.contentString = contentString;
	}

	public String getLogoString() {
		return this.logoString;
	}

	public void setLogoString(String logoString) {
		this.logoString = logoString;
	}

	public String getAdUrlString() {
		return this.adUrlString;
	}

	public void setAdUrlString(String adUrlString) {
		this.adUrlString = adUrlString;
	}

	public String getShowStatusString() {
		return this.showStatusString;
	}

	public void setShowStatusString(String showStatusString) {
		this.showStatusString = showStatusString;
	}

	public Integer getShowOrderInt() {
		return this.showOrderInt;
	}

	public void setShowOrderInt(Integer showOrderInt) {
		this.showOrderInt = showOrderInt;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getStatusInt() {
		return this.statusInt;
	}

	public void setStatusInt(Integer statusInt) {
		this.statusInt = statusInt;
	}

}