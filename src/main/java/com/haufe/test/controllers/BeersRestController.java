package com.haufe.test.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.haufe.test.api.BeersRestApi;
import com.haufe.test.dto.BeerDto;
import com.haufe.test.dto.BeerPage;
import com.haufe.test.dto.SearchCriteriaBeers;
import com.haufe.test.entities.BeersEntity;
import com.haufe.test.services.BeersService;
import com.haufe.test.utils.Constants;

@RestController
public class BeersRestController implements BeersRestApi {

	@Autowired
	BeersService beersService;

	@Override
	public ResponseEntity<Page<BeersEntity>> getBeers(BeerPage beerPage, SearchCriteriaBeers beerDto) {
		return new ResponseEntity<>(beersService.getListBeer(beerPage, beerDto), HttpStatus.OK);
	}

	@Override
	public BeerDto getBeerById(@PathVariable int beerId) {
		return beersService.getBeerByBeerId(beerId);
	}

	@Override
	public ResponseEntity<String> saveBeer(@Valid @RequestBody BeerDto beerDto, BindingResult validation) {
		if (!validation.hasErrors()) {
			return beersService.createBeer(beerDto);
		}
		return new ResponseEntity<String>(Constants.FIELDS_EMPTY, HttpStatus.BAD_REQUEST);

	}

	@Override
	public ResponseEntity<String> updateBeer(@RequestBody BeerDto beerDto, BindingResult result) {
		if (!result.hasErrors()) {
			return beersService.updateBeerId(beerDto);
		}
		return new ResponseEntity<String>(Constants.FIELDS_EMPTY, HttpStatus.BAD_REQUEST);
	}

	@Override
	public void deleteBeer(@PathVariable int beerId) {
		beersService.deleteBeerId(beerId);

	}

}
