package com.haufe.test.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.haufe.test.dto.ManufacturerDto;
import com.haufe.test.entities.ManufacturerEntity;
import com.haufe.test.exception.TestException;
import com.haufe.test.repository.ManufacturerTableRepository;
import com.haufe.test.services.ManufacturersService;
import com.haufe.test.utils.Constants;

@Service
public class ManufacturerServiceImpl implements ManufacturersService {

	@Autowired
	ManufacturerTableRepository manufacturarerTableRepository;
	@Autowired
	@Qualifier(value = "mapperService")
	private Mapper mapper;

	List<ManufacturerDto> manufacturerDto = null;
	List<ManufacturerEntity> manufacturerEntity = null;

	@Override
	public List<ManufacturerDto> getListManufacturer() {
		manufacturerEntity = manufacturarerTableRepository.findAll();
		manufacturerDto = manufacturerEntity.stream()
				.map(providerConfiguration -> mapper.map(providerConfiguration, ManufacturerDto.class))
				.collect(Collectors.toList());
		return manufacturerDto;
	}

	@Override
	public ManufacturerDto getManufacturerByManufacturerId(int manufacturerId) {
		ManufacturerEntity manufacturerEntity = manufacturarerTableRepository.findById(manufacturerId).orElseThrow(()-> new TestException(Constants.NOT_FOUND));
		return mapper.map(manufacturerEntity, ManufacturerDto.class);

	
	}

	@Override
	public ResponseEntity<String> createManufacturer(ManufacturerDto manufacturerDto) {
		Optional<ManufacturerEntity> manufacturer = manufacturarerTableRepository
				.findById(manufacturerDto.getManufacturerId());
		if (manufacturer.isPresent()) {
			return new ResponseEntity<String>(Constants.ALREADY_REPORTED, HttpStatus.ALREADY_REPORTED);
		}
		ManufacturerEntity manufacturerEntity = mapper.map(manufacturerDto, ManufacturerEntity.class);
		ManufacturerEntity b = manufacturarerTableRepository.save(manufacturerEntity);
		return new ResponseEntity<String>(Constants.MANUFACTURER_ID+Integer.toString(b.getManufacturerId()), HttpStatus.CREATED);


	}

	@Override
	public ResponseEntity<String>  updateManufacturer(ManufacturerDto manufacturerDto) {
		    manufacturarerTableRepository.findById(manufacturerDto.getManufacturerId()).orElseThrow(()-> new TestException(Constants.NOT_FOUND));
			ManufacturerEntity manufacturerToMidified = (mapper.map(manufacturerDto, ManufacturerEntity.class));
			manufacturarerTableRepository.save(manufacturerToMidified);
			return new ResponseEntity<String>(Constants.OK, HttpStatus.OK);
		


	}

	@Override
	public void deleteManufacturerId(int manufacturerId) {
		manufacturarerTableRepository.findById(manufacturerId).orElseThrow(()-> new TestException(Constants.NOT_FOUND));
		manufacturarerTableRepository.deleteById(manufacturerId);

	}
	
	

}
