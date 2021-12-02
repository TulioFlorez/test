package com.haufe.test.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.haufe.test.api.ManufacturersRestApi;
import com.haufe.test.dto.ManufacturerDto;
import com.haufe.test.services.ManufacturersService;
import com.haufe.test.utils.Constants;

@RestController
public class ManufacturersRestController implements ManufacturersRestApi {

	@Autowired
	ManufacturersService manufacturersService;

	@Override
	public List<ManufacturerDto> getManufacturers() {

		return manufacturersService.getListManufacturer();
	}

	@Override
	public ManufacturerDto getManufacturerById(@PathVariable int manufacturerId) {
		return manufacturersService.getManufacturerByManufacturerId(manufacturerId);
	}

	@Override

	public ResponseEntity<String> saveManufacturer(@Valid @RequestBody ManufacturerDto manufacturerDto,
			BindingResult result) {
		if (!result.hasErrors()) {
			return manufacturersService.createManufacturer(manufacturerDto);
		}
		return new ResponseEntity<String>(Constants.FIELDS_EMPTY, HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<String> updateManufacturer(@Valid @RequestBody ManufacturerDto manufacturerDto,
			BindingResult result) {
		if (!result.hasErrors()) {
			return manufacturersService.updateManufacturer(manufacturerDto);
		}
		return new ResponseEntity<String>(Constants.FIELDS_EMPTY, HttpStatus.BAD_REQUEST);

	}

	@Override
	public void deleteManufacturer(@PathVariable int manufacturerId) {
		manufacturersService.deleteManufacturerId(manufacturerId);

	}

}
