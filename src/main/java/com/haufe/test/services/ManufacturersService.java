package com.haufe.test.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.haufe.test.dto.ManufacturerDto;

public interface ManufacturersService {
	/**
	 * 
	 * @return
	 */
	public List<ManufacturerDto> getListManufacturer();

	/**
	 * .
	 * 
	 * @param ManufacturerId
	 * @return
	 */
	public ManufacturerDto getManufacturerByManufacturerId(int manufacturerId);

	/**
	 * 
	 * @param manufacturer
	 * @return
	 */
	public ResponseEntity<String> createManufacturer(ManufacturerDto manufacturer);

	/**
	 * 
	 * @param manufacturer
	 * @return
	 */
	public ResponseEntity<String> updateManufacturer(ManufacturerDto manufacturer);

	/**
	 * 
	 * @param manufacturerId
	 */
	public void deleteManufacturerId(int manufacturerId);
}
