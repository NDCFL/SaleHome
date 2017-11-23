package com.ht.pojo;

import java.util.Date;

/**
 * TRolePermission entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TRolePermission implements java.io.Serializable {

	// Fields

	private String idString;
	private String roleIdString;
	private String permissionIdString;
	private Date createdTime;

	// Constructors

	/** default constructor */
	public TRolePermission() {
	}

	/** minimal constructor */
	public TRolePermission(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public TRolePermission(String idString, String roleIdString,
			String permissionIdString, Date createdTime) {
		this.idString = idString;
		this.roleIdString = roleIdString;
		this.permissionIdString = permissionIdString;
		this.createdTime = createdTime;
	}

	// Property accessors

	public String getIdString() {
		return this.idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public String getRoleIdString() {
		return this.roleIdString;
	}

	public void setRoleIdString(String roleIdString) {
		this.roleIdString = roleIdString;
	}

	public String getPermissionIdString() {
		return this.permissionIdString;
	}

	public void setPermissionIdString(String permissionIdString) {
		this.permissionIdString = permissionIdString;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

}