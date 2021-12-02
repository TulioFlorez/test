package com.haufe.test.api;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haufe.test.dto.BeerDto;
import com.haufe.test.dto.BeerPage;
import com.haufe.test.dto.SearchCriteriaBeers;
import com.haufe.test.entities.BeersEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"Beers"})
@RequestMapping(path = { "/beers"}, produces = {MediaType.APPLICATION_JSON_VALUE} )
public interface BeersRestApi {
	
	/**
	 * 
	 * @param beerPage
	 * @param beerDto
	 * @return
	 */
	@ApiOperation(
			value = "list beer detail", 
		    notes = "Returns  list  of  beers by search criteria",
		    response = Page.class)
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "Not found"),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 400, message = "Bad Request")})
	@GetMapping()
	public ResponseEntity<Page<BeersEntity>>   getBeers(BeerPage beerPage,
			SearchCriteriaBeers beerDto);
	/**
	 * 	
	 * @param beerId
	 * @return
	 */
	

		@ApiOperation(
				value = "beer detail", 
			    notes = "Returns  a  beer by id",
			    response = BeerDto.class)
		@ApiResponses(value = {
				@ApiResponse(code = 500, message = "Internal server error"),
				@ApiResponse(code = 404, message = "Not found"),
				@ApiResponse(code = 401, message = "Unauthorized"),
				@ApiResponse(code = 400, message = "Bad Request")})
		@GetMapping(value = "beerId/{beerId:[0-9]{1,10}}")
		public BeerDto   getBeerById(@PathVariable( value ="beerId", required = true) int beerId);
	
	/**
	 * 	
	 * @param beerDto
	 * @param result
	 * @return
	 */
		
		@ApiOperation(
				value = " save beer detail", 
			    notes = "Returns  a  string id beer",
			    response = String.class)
		@ApiResponses(value = {
				@ApiResponse(code = 500, message = "Internal server error"),
				@ApiResponse(code = 404, message = "Not found"),
				@ApiResponse(code = 401, message = "Unauthorized"),
				@ApiResponse(code = 400, message = "Bad Request")})
		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<String>  saveBeer( @Valid @RequestBody BeerDto beerDto, BindingResult result);
		
	/**
	 * 		
	 * @param beerDto
	 * @param result
	 * @return
	 */
		
		@ApiOperation(
				value = " modified beer detail", 
			    notes = "Returns  a  string if it was success or fail",
			    response = String.class)
		@ApiResponses(value = {
				@ApiResponse(code = 500, message = "Internal server error"),
				@ApiResponse(code = 404, message = "Not found"),
				@ApiResponse(code = 401, message = "Unauthorized"),
				@ApiResponse(code = 400, message = "Bad Request")})
		@RequestMapping(method = RequestMethod.PUT)
		public ResponseEntity<String>  updateBeer(@Valid @RequestBody BeerDto beerDto, BindingResult result);
	/**
	 * 		
	 * @param beerId
	 */
		
		
		@ApiOperation(
				value = " delete beer detail", 
			    notes = " no Returns",
			    response = String.class)
		@ApiResponses(value = {
				@ApiResponse(code = 500, message = "Internal server error"),
				@ApiResponse(code = 404, message = "Not found"),
				@ApiResponse(code = 401, message = "Unauthorized"),
				@ApiResponse(code = 400, message = "Bad Request")})
		@DeleteMapping(value = "idbeer/{beerId:[0-9]{1,10}}")
		public void  deleteBeer(@PathVariable( value ="beerId", required = true) int beerId);
		

	
}
