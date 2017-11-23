package com.ht.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * TRoom entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TRoom implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idString;
	private String houseIdString;
	private String buildingIdString;
	private String nameString;
	private Integer saleStatusInt;
	private String roominfoString;
	public String getRoominfoString() {
		return roominfoString;
	}
	public void setRoominfoString(String roominfoString) {
		this.roominfoString = roominfoString;
	}
	private TBuilding loudong;
	private THouse huxing;
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public String getHouseIdString() {
		return houseIdString;
	}
	public void setHouseIdString(String houseIdString) {
		this.houseIdString = houseIdString;
	}
	public String getBuildingIdString() {
		return buildingIdString;
	}
	public void setBuildingIdString(String buildingIdString) {
		this.buildingIdString = buildingIdString;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public Integer getSaleStatusInt() {
		return saleStatusInt;
	}
	public void setSaleStatusInt(Integer saleStatusInt) {
		this.saleStatusInt = saleStatusInt;
	}
	public TBuilding getLoudong() {
		return loudong;
	}
	public void setLoudong(TBuilding loudong) {
		this.loudong = loudong;
	}
	public THouse getHuxing() {
		return huxing;
	}
	public void setHuxing(THouse huxing) {
		this.huxing = huxing;
	}
	
}