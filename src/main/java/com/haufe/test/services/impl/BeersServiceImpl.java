package com.haufe.test.services.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.dozer.Mapper;
import org.hibernate.TransientPropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.haufe.test.dto.BeerDto;
import com.haufe.test.dto.BeerPage;
import com.haufe.test.dto.SearchCriteriaBeers;
import com.haufe.test.entities.BeersEntity;
import com.haufe.test.exception.TestException;
import com.haufe.test.repository.BeerTableRepository;
import com.haufe.test.repository.CriteriaSearchBeersRepository;
import com.haufe.test.services.BeersService;
import com.haufe.test.utils.Constants;

@Service
public class BeersServiceImpl implements BeersService {

	@Autowired
	BeerTableRepository beerTableRepository;

	@Autowired
	CriteriaSearchBeersRepository criteriaSearchBeersRepository;

	@Autowired
	@Qualifier(value = "mapperService")
	private Mapper mapper;

	@Override
	public Page<BeersEntity> getListBeer(BeerPage beerPage, SearchCriteriaBeers beerDto) {
		return criteriaSearchBeersRepository.findAllWithFilters(beerPage, beerDto);

	}

	@Override
	public BeerDto getBeerByBeerId(int beerId) {
		Optional<BeersEntity> beersEntity = beerTableRepository.findById(beerId);
		if (!beersEntity.isPresent()) {
			return callPunkApi(beerId);
		} else {
			return mapper.map(beersEntity.get(), BeerDto.class);
		}
	}

	@Override
	public ResponseEntity<String> updateBeerId(BeerDto beerDto) {
		beerTableRepository.findById(beerDto.getBeerId()).orElseThrow(() -> new TestException(Constants.BAD_REQUEST));
		beerTableRepository.save((mapper.map(beerDto, BeersEntity.class)));
		return new ResponseEntity<String>(Constants.OK, HttpStatus.OK);

	}

	@Override
	public void deleteBeerId(int beerId) {
		beerTableRepository.findById(beerId).orElseThrow(() -> new TestException(Constants.BAD_REQUEST));
		beerTableRepository.deleteById(beerId);

	}

	@Override
	public ResponseEntity<String> createBeer(BeerDto beerDto) {
		Optional<BeersEntity> beer = beerTableRepository.findById(beerDto.getBeerId());
		if (beer.isPresent()) {
			return new ResponseEntity<String>(Constants.ALREADY_REPORTED, HttpStatus.ALREADY_REPORTED);
		}

		try {
			BeersEntity beersEntity = beerTableRepository.save(mapper.map(beerDto, BeersEntity.class));
			return new ResponseEntity<String>(Constants.MANUFACTURER_ID + Integer.toString(beersEntity.getBeerId()),
					HttpStatus.CREATED);

		} catch (RuntimeException e) {
			throw new TestException(Constants.Error_ID);
		}

	}

	private BeerDto callPunkApi(int beerId) {
		BeerDto beerDto = new BeerDto();
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
			RestTemplate seizureOutTemplate = new RestTemplate();

			URI urlUri;
			urlUri = new URI(String.format("%s/%s", "https://api.punkapi.com/v2/beers", Integer.toString(beerId)));

			ResponseEntity<BeerDto> response = seizureOutTemplate.exchange(urlUri, HttpMethod.GET, requestEntity,
					new ParameterizedTypeReference<BeerDto>() {
					});
			if (200 == response.getStatusCode().value()) {

				beerDto.setName(response.getBody().getName());
				beerDto.setDescription(response.getBody().getDescription());
				return beerDto;
			}
		} catch (URISyntaxException e) {

			throw new TestException(e.getMessage());
		} catch (RuntimeException ex) {

			throw new TestException("something is wrong with with your Proxy" + ex.getMessage());
		}
		return beerDto;
	}
}
