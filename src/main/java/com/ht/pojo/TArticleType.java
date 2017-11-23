package com.ht.pojo;

/**
 * TArticleType entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TArticleType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idString;
	private String nameString;
	private String desString;

	// Constructors

	/** default constructor */
	public TArticleType() {
	}

	/** minimal constructor */
	public TArticleType(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public TArticleType(String idString, String nameString, String desString) {
		this.idString = idString;
		this.nameString = nameString;
		this.desString = desString;
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

}