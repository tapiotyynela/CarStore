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
import com.example.CarStore.domain.User;
import com.example.CarStore.domain.UserRepository;




@SpringBootApplication
public class CarStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(CarStoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(CarStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CarRepository repository, SalesManRepository srepository, UserRepository urepository) {
		return new CommandLineRunner () {
			@Override
			public void run(String... args) throws Exception {
			
			User user1 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");

				
			log.info("fetch all cars");
			for (Car car: repository.findAll()) {
				log.info(car.toString());
			}}

		};
	}
}
