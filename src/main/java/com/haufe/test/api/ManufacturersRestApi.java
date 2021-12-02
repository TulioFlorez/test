package com.haufe.test.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haufe.test.dto.ManufacturerDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"Manufacturers"})
@RequestMapping(path = { "/manufacturers"}, produces = {MediaType.APPLICATION_JSON_VALUE} )
public interface ManufacturersRestApi {
	
	/**
	 * 
	 * @return
	 */
	@ApiOperation(
			value = "manufacturer detail", 
		    notes = "Returns  list  of  manufacturers",
		    response = String.class)
	@ApiResponses(value = {
			
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "Not found"),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 400, message = "Bad Request")})
	
	@GetMapping()
	public List<ManufacturerDto>  getManufacturers();
	
	/**
	 * 
	 * @param manufacturerId
	 * @return
	 */

		@ApiOperation(
				value = "manufacturers detail", 
			    notes = "Returns  a  manufacturers by id",
			    response = String.class)
		@ApiResponses(value = {
				@ApiResponse(code = 500, message = "Internal server error"),
				@ApiResponse(code = 404, message = "Not found"),
				@ApiResponse(code = 401, message = "Unauthorized"),
				@ApiResponse(code = 400, message = "Bad Request")})
		@GetMapping(value = "manufacturerId/{manufacturerId:[0-9]{1,10}}")
		public ManufacturerDto  getManufacturerById(@PathVariable( value ="manufacturerId", required = true) int manufacturerId);
	
		/**
		 * 
		 * @param manufacturerDto
		 * @param result
		 * @return
		 */
		@ApiOperation(
				value = " save manufacturers detail", 
			    notes = "Returns  a  beers",
			    response = String.class)
		@ApiResponses(value = {
				@ApiResponse(code = 208, message = "existe"),
				@ApiResponse(code = 500, message = "Internal server error"),
				@ApiResponse(code = 404, message = "Not found"),
				@ApiResponse(code = 401, message = "Unauthorized"),
				@ApiResponse(code = 400, message = "Bad Request")})
		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<String>  saveManufacturer( @RequestBody ManufacturerDto manufacturerDto,BindingResult result);
		
		/**
		 * 
		 * @param manufacturerDto
		 * @param result
		 * @return
		 */
		
		@ApiOperation(
				value = " modified manufacturers detail", 
			    notes = "Returns  a  manufacturerD",
			    response = String.class)
		@ApiResponses(value = {
				@ApiResponse(code = 500, message = "Internal server error"),
				@ApiResponse(code = 404, message = "Not found"),
				@ApiResponse(code = 401, message = "Unauthorized"),
				@ApiResponse(code = 400, message = "Bad Request")})
		@RequestMapping(method = RequestMethod.PUT)
		public ResponseEntity<String>  updateManufacturer( @RequestBody ManufacturerDto manufacturerDto, BindingResult result);
		
		/**
		 * 
		 * @param manufacturerId
		 */
		
		@ApiOperation(
				value = " delete manufacturer detail", 
			    notes = "Returns  a  beers",
			    response = String.class)
		@ApiResponses(value = {
				@ApiResponse(code = 500, message = "Internal server error"),
				@ApiResponse(code = 404, message = "Not found"),
				@ApiResponse(code = 401, message = "Unauthorized"),
				@ApiResponse(code = 400, message = "Bad Request")})
		@DeleteMapping(value = "manufacturerId/{manufacturerId:[0-9]{1,10}}")
		public void  deleteManufacturer( @PathVariable( value ="manufacturerId", required = true) int manufacturerId);

	
	


}
