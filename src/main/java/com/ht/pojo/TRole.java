package com.ht.pojo;

import java.util.Date;

/**
 * TRole entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TRole implements java.io.Serializable {

	// Fields

	private String idString;
	private String nameString;
	private String desString;
	private Date createdTime;
	private Integer statusInt;

	// Constructors

	/** default constructor */
	public TRole() {
	}

	/** minimal constructor */
	public TRole(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public TRole(String idString, String nameString, String desString,
			Date createdTime, Integer statusInt) {
		this.idString = idString;
		this.nameString = nameString;
		this.desString = desString;
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

	public String getNameString() {
		return this.nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public String getDesString() {
		return this.desString;
	}

	public void setDesString(String desString) {
		this.desString = desString;
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