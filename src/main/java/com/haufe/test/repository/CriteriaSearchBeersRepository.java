package com.haufe.test.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.haufe.test.dto.BeerPage;
import com.haufe.test.dto.SearchCriteriaBeers;
import com.haufe.test.entities.BeersEntity;
@Repository("criteriaSearchBeersRepository")
public class CriteriaSearchBeersRepository {
	
	  private final EntityManager entityManager;
	    private final CriteriaBuilder criteriaBuilder;

	    public CriteriaSearchBeersRepository(EntityManager entityManager) {
	        this.entityManager = entityManager;
	        this.criteriaBuilder = entityManager.getCriteriaBuilder();
	    }

	    public Page<BeersEntity> findAllWithFilters(BeerPage beerPage,
	    		SearchCriteriaBeers beerDto){
	        CriteriaQuery<BeersEntity> criteriaQuery = criteriaBuilder.createQuery(BeersEntity.class);
	        Root<BeersEntity> beersEntityRoot = criteriaQuery.from(BeersEntity.class);
	        Predicate predicate = getPredicate(beerDto, beersEntityRoot);
	        criteriaQuery.where(predicate);
	        setOrder(beerPage, criteriaQuery, beersEntityRoot);

	        TypedQuery<BeersEntity> typedQuery = entityManager.createQuery(criteriaQuery);
	        typedQuery.setFirstResult(beerPage.getPageNumber() * beerPage.getPageSize());
	        typedQuery.setMaxResults(beerPage.getPageSize());

	        Pageable pageable = getPageable(beerPage);

	        long BeersCount = getEmployeesCount(predicate);

	        return new PageImpl<>(typedQuery.getResultList(), pageable, BeersCount);
	    }

	    private Predicate getPredicate(SearchCriteriaBeers beerDto,
	                                   Root<BeersEntity> BeersEntityRoot) {
	        List<Predicate> predicates = new ArrayList<>();
	        if(Objects.nonNull(beerDto.getName())){
	            predicates.add(
	                    criteriaBuilder.like(BeersEntityRoot.get("name"),
	                            "%" + beerDto.getName() + "%")
	            );
	        }
	        if(Objects.nonNull(beerDto.getDescription())){
	            predicates.add(
	                    criteriaBuilder.like(BeersEntityRoot.get("description"),
	                            "%" + beerDto.getDescription() + "%")
	            );
	        }

	        if(Objects.nonNull(beerDto.getType())){
	            predicates.add(
	                    criteriaBuilder.like(BeersEntityRoot.get("type"),
	                            "%" + beerDto.getType() + "%")
	            );
	            
	        }
	        
	        if(Objects.nonNull(beerDto.getPrivategraduation())){
	            predicates.add(
	                    criteriaBuilder.like(BeersEntityRoot.get("privategraduation"),
	                            "%" + beerDto.getPrivategraduation() )
	            );
    
	        }
	        
	        if(Objects.nonNull(beerDto.getManufactureId())&& beerDto.getManufactureId()!=0 ){
	            predicates.add(
	                    criteriaBuilder.equal(BeersEntityRoot.<Integer>get("manufactureId"),
	                    		 beerDto.getManufactureId())
	            );
    
	        }
	        
	        
	        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	    }

	    private void setOrder(BeerPage beerPage,
	                          CriteriaQuery<BeersEntity> criteriaQuery,
	                          Root<BeersEntity> employeeRoot) {
	        if(beerPage.getSortDirection().equals(Sort.Direction.ASC)){
	            criteriaQuery.orderBy(criteriaBuilder.asc(employeeRoot.get(beerPage.getSortBy())));
	        } else {
	            criteriaQuery.orderBy(criteriaBuilder.desc(employeeRoot.get(beerPage.getSortBy())));
	        }
	    }

	    private Pageable getPageable(BeerPage beerPage) {
	        Sort sort = Sort.by(beerPage.getSortDirection(), beerPage.getSortBy());
	        return PageRequest.of(beerPage.getPageNumber(),beerPage.getPageSize(), sort);
	    }

	    private long getEmployeesCount(Predicate predicate) {
	        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
	        Root<BeersEntity> countRoot = countQuery.from(BeersEntity.class);
	        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
	        return entityManager.createQuery(countQuery).getSingleResult();
	    }
	}


