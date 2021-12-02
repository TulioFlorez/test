package com.haufe.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.haufe.test.entities.BeersEntity;

@Repository("beerTableRepository")
public interface BeerTableRepository extends JpaRepository<BeersEntity, Integer>, PagingAndSortingRepository<BeersEntity, Integer> {
	
	
	
	


}
