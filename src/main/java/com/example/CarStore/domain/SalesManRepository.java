package com.example.CarStore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SalesManRepository extends CrudRepository<SalesMan, Long> {
	
	List<SalesMan> findByLastName(String lastName);

}
