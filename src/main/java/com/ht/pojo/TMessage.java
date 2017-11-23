package com.ht.pojo;

import java.util.Date;

/**
 * TMessage entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TMessage implements java.io.Serializable {

	// Fields

	private String idString;
	private String content;
	private String buildingsIdString;
	private String replyString;
	private Date leaveTime;
	private Date replyTime;
	private String userIdString;
	private Integer status;

	// Constructors

	/** default constructor */
	public TMessage() {
	}

	/** minimal constructor */
	public TMessage(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public TMessage(String idString, String content, String buildingsIdString,
			String replyString, Date leaveTime, Date replyTime,
			String userIdString, Integer status) {
		this.idString = idString;
		this.content = content;
		this.buildingsIdString = buildingsIdString;
		this.replyString = replyString;
		this.leaveTime = leaveTime;
		this.replyTime = replyTime;
		this.userIdString = userIdString;
		this.status = status;
	}

	// Property accessors

	public String getIdString() {
		return this.idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBuildingsIdString() {
		return this.buildingsIdString;
	}

	public void setBuildingsIdString(String buildingsIdString) {
		this.buildingsIdString = buildingsIdString;
	}

	public String getReplyString() {
		return this.replyString;
	}

	public void setReplyString(String replyString) {
		this.replyString = replyString;
	}

	public Date getLeaveTime() {
		return this.leaveTime;
	}

	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}

	public Date getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public String getUserIdString() {
		return this.userIdString;
	}

	public void setUserIdString(String userIdString) {
		this.userIdString = userIdString;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}