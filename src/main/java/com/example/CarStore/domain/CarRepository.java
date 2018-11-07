package com.example.CarStore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
	
	List<Car> findByRegisterNumber(String registerNumber);
	Car findCarsById(Long id);

}
