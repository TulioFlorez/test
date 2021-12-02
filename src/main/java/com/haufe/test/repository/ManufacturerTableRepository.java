package com.haufe.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haufe.test.entities.ManufacturerEntity;

@Repository("manufacturerTableRepository")
public interface ManufacturerTableRepository extends JpaRepository<ManufacturerEntity, Integer> {

}
