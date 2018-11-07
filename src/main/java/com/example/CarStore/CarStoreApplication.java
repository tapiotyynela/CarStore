package com.example.CarStore;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.CarStore.CarStoreApplication;
import com.example.CarStore.domain.Car;
import com.example.CarStore.domain.CarRepository;
import com.example.CarStore.domain.SalesMan;
import com.example.CarStore.domain.SalesManRepository;


@SpringBootApplication
public class CarStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(CarStoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(CarStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CarRepository repository, SalesManRepository srepository) {
		return new CommandLineRunner () {
			@Override
			public void run(String... args) throws Exception {
			log.info("save a couple of cars");
			srepository.save(new SalesMan("Tapio", "Tyynela"));
			srepository.save(new SalesMan("Niko", "Virolainen"));
			
			repository.save(new Car("Pakettiauto", "WolksVagen", "Vito", "Paketti", "2000", "Blue", "Manual", "Diesel", "123-abc", 5000, srepository.findByLastName("Tyynela").get(0)));
			repository.save(new Car("Kuorma-auto", "Scania", "moi", "Kuormuri", "2005", "Red", "Manual", "Bensin", "456-def", 30000, srepository.findByLastName("Virolainen").get(0)));	
			
			log.info("fetch all cars");
			for (Car car: repository.findAll()) {
				log.info(car.toString());
			}}

		};
	}
}
