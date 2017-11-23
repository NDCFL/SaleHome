package com.ht.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TBuilding entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TBuilding implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idString;
	private String nameString;
	private Integer totalFloorInt;
	private Integer totalLiftInt;
	private Integer floorRoomsInt;
	private Integer totalRoomInt;
	private String buildingsId;
	private Date createdTimeString;
	private Integer statusInt;
	private TBuildings buildings;
	private String jxsidString;
	private Set<THouse> houseset = new HashSet<THouse>();
	public Set<THouse> getHouseset() {
		return houseset;
	}

	public void setHouseset(Set<THouse> houseset) {
		this.houseset = houseset;
	}

	public String getJxsidString() {
		return jxsidString;
	}

	public void setJxsidString(String jxsidString) {
		this.jxsidString = jxsidString;
	}

	private TAgency tagency;
	// Constructors

	public TAgency getTagency() {
		return tagency;
	}

	public void setTagency(TAgency tagency) {
		this.tagency = tagency;
	}

	/** default constructor */
	public TBuilding() {
	}

	public TBuildings getBuildings() {
		return buildings;
	}

	public void setBuildings(TBuildings buildings) {
		this.buildings = buildings;
	}

	/** minimal constructor */
	public TBuilding(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public TBuilding(String idString, String nameString, Integer totalFloorInt,
			Integer totalLiftInt, Integer floorRoomsInt, Integer totalRoomInt,
			String buildingsId, Date createdTimeString, Integer statusInt) {
		this.idString = idString;
		this.nameString = nameString;
		this.totalFloorInt = totalFloorInt;
		this.totalLiftInt = totalLiftInt;
		this.floorRoomsInt = floorRoomsInt;
		this.totalRoomInt = totalRoomInt;
		this.buildingsId = buildingsId;
		this.createdTimeString = createdTimeString;
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

	public Integer getTotalFloorInt() {
		return this.totalFloorInt;
	}

	public void setTotalFloorInt(Integer totalFloorInt) {
		this.totalFloorInt = totalFloorInt;
	}

	public Integer getTotalLiftInt() {
		return this.totalLiftInt;
	}

	public void setTotalLiftInt(Integer totalLiftInt) {
		this.totalLiftInt = totalLiftInt;
	}

	public Integer getFloorRoomsInt() {
		return this.floorRoomsInt;
	}

	public void setFloorRoomsInt(Integer floorRoomsInt) {
		this.floorRoomsInt = floorRoomsInt;
	}

	public Integer getTotalRoomInt() {
		return this.totalRoomInt;
	}

	public void setTotalRoomInt(Integer totalRoomInt) {
		this.totalRoomInt = totalRoomInt;
	}

	public String getBuildingsId() {
		return this.buildingsId;
	}

	public void setBuildingsId(String buildingsId) {
		this.buildingsId = buildingsId;
	}

	public Date getCreatedTimeString() {
		return this.createdTimeString;
	}

	public void setCreatedTimeString(Date createdTimeString) {
		this.createdTimeString = createdTimeString;
	}

	public Integer getStatusInt() {
		return this.statusInt;
	}

	public void setStatusInt(Integer statusInt) {
		this.statusInt = statusInt;
	}

}