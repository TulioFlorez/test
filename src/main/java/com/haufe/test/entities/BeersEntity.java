package com.haufe.test.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BeersEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int beerId;
	private String name;
	private String privategraduation;
	private String type;
	private String description;
	@ManyToOne
	@JoinColumn(name = "ManufacturerId")
	private ManufacturerEntity manufactureId;

	/**
	 * @return the beerId
	 */
	public int getBeerId() {
		return beerId;
	}

	/**
	 * @param beerId
	 *            the beerId to set
	 */
	public void setBeerId(int beerId) {
		this.beerId = beerId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the privategraduation
	 */
	public String getPrivategraduation() {
		return privategraduation;
	}

	/**
	 * @param privategraduation
	 *            the privategraduation to set
	 */
	public void setPrivategraduation(String privategraduation) {
		this.privategraduation = privategraduation;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the manufactureId
	 */
	public ManufacturerEntity getManufactureId() {
		return manufactureId;
	}

	/**
	 * @param manufactureId
	 *            the manufactureId to set
	 */
	public void setManufactureId(ManufacturerEntity manufactureId) {
		this.manufactureId = manufactureId;
	}

}
