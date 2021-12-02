package com.haufe.test.services;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.haufe.test.dto.BeerDto;
import com.haufe.test.dto.BeerPage;
import com.haufe.test.dto.SearchCriteriaBeers;
import com.haufe.test.entities.BeersEntity;

public interface BeersService {
	/**
	 * 
	 * @param beerPage
	 * @param beerDto
	 * @return
	 */
	public Page<BeersEntity> getListBeer(BeerPage beerPage, SearchCriteriaBeers beerDto);

	/**
	 * 
	 * @param beerId
	 * @return
	 */

	public BeerDto getBeerByBeerId(int beerId);

	/**
	 * 
	 * @param beer
	 * @return
	 */
	public ResponseEntity<String> createBeer(BeerDto beer);

	/**
	 * 
	 * @param beer
	 * @return
	 */
	public ResponseEntity<String> updateBeerId(BeerDto beer);

	/**
	 * 
	 * @param beerId
	 */
	public void deleteBeerId(int beerId);

}
