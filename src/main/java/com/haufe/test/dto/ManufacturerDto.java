package com.haufe.test.dto;

import javax.validation.constraints.NotBlank;

public class ManufacturerDto {

	private int ManufacturerId = 0;
	@NotBlank()
	private String name = "";
	@NotBlank()
	private String nationality = "";

	/**
	 * @return the manufacturerId
	 */
	public int getManufacturerId() {
		return ManufacturerId;
	}

	/**
	 * @param manufacturerId
	 *            the manufacturerId to set
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
	 * @param name
	 *            the name to set
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
	 * @param nationality
	 *            the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

}
