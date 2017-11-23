package com.ht.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * THouse entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class THouse implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String idString;
	private String nameString;
	private String logoString;
	private String introString;
	private Double areaDouble;
	private Double unitPriceDouble;
	private Date createdTime;
	private Integer statusInt;
	private String buildidString;
	private TBuilding tbuilding;
	private String jxsidString;
	public String getJxsidString() {
		return jxsidString;
	}
	public void setJxsidString(String jxsidString) {
		this.jxsidString = jxsidString;
	}
	private Set<TRoom> rooset = new HashSet<TRoom>();
	public Set<TRoom> getRooset() {
		return rooset;
	}
	public void setRooset(Set<TRoom> rooset) {
		this.rooset = rooset;
	}
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getLogoString() {
		return logoString;
	}
	public void setLogoString(String logoString) {
		this.logoString = logoString;
	}
	public String getIntroString() {
		return introString;
	}
	public void setIntroString(String introString) {
		this.introString = introString;
	}
	public Double getAreaDouble() {
		return areaDouble;
	}
	public void setAreaDouble(Double areaDouble) {
		this.areaDouble = areaDouble;
	}
	public Double getUnitPriceDouble() {
		return unitPriceDouble;
	}
	public void setUnitPriceDouble(Double unitPriceDouble) {
		this.unitPriceDouble = unitPriceDouble;
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
	public String getBuildidString() {
		return buildidString;
	}
	public void setBuildidString(String buildidString) {
		this.buildidString = buildidString;
	}
	public TBuilding getTbuilding() {
		return tbuilding;
	}
	public void setTbuilding(TBuilding tbuilding) {
		this.tbuilding = tbuilding;
	}
	
}