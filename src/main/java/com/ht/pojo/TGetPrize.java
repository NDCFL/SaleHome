package com.ht.pojo;

import java.io.Serializable;
import java.util.Date;

public class TGetPrize implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idString;
	private String useridString;
	private String prizenameString;
	private int prizetypeInt;
	private Date createdTime;
	private TUser user;
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public String getUseridString() {
		return useridString;
	}
	public void setUseridString(String useridString) {
		this.useridString = useridString;
	}
	public String getPrizenameString() {
		return prizenameString;
	}
	public void setPrizenameString(String prizenameString) {
		this.prizenameString = prizenameString;
	}
	public int getPrizetypeInt() {
		return prizetypeInt;
	}
	public void setPrizetypeInt(int prizetypeInt) {
		this.prizetypeInt = prizetypeInt;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public TUser getUser() {
		return user;
	}
	public void setUser(TUser user) {
		this.user = user;
	}
}
