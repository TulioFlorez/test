package com.haufe.test.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BeerDto {

	private int beerId = 1;
	@NotBlank()
	private String name;
	@NotBlank()
	private String privategraduation;
	@NotBlank()
	private String type;
	@NotBlank()
	private String description;
	@NotNull()
	private int manufactureId;

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
	public int getManufactureId() {
		return manufactureId;
	}

	/**
	 * @param manufactureId
	 *            the manufactureId to set
	 */
	public void setManufactureId(int manufactureId) {
		this.manufactureId = manufactureId;
	}

}
