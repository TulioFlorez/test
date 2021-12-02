package com.haufe.test.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity 
public class ManufacturerEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int ManufacturerId;
	private String name;
	private String nationality;
	private String userId;
	private String userModifiedid;
	private String date;
	private String dateModified;
	/**
	 * @return the manufacturerId
	 */
	public int getManufacturerId() {
		return ManufacturerId;
	}
	/**
	 * @param manufacturerId the manufacturerId to set
	 */
	public void setManufacturerId(int manufacturerId) {
		ManufacturerId = manufacturerId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}
	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the userModifiedid
	 */
	public String getUserModifiedid() {
		return userModifiedid;
	}
	/**
	 * @param userModifiedid the userModifiedid to set
	 */
	public void setUserModifiedid(String userModifiedid) {
		this.userModifiedid = userModifiedid;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the dateModified
	 */
	public String getDateModified() {
		return dateModified;
	}
	/**
	 * @param dateModified the dateModified to set
	 */
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}
	
	

}
