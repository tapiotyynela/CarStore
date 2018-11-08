package com.example.CarStore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.CarStore.domain.Car;
import com.example.CarStore.domain.CarRepository;
import com.example.CarStore.domain.SalesManRepository;


import com.example.CarStore.domain.SalesMan;

@Controller
public class CarStoreController {
		
	@Autowired
	private CarRepository repository;
	
	@Autowired
	private SalesManRepository srepository;
	
	 @RequestMapping(value="/carlist", method = RequestMethod.GET)
	    public String carList(Model model) {	
	        model.addAttribute("cars", repository.findAll());
	        return "carlist";
}
	
	@GetMapping(value="/")
	public String index() {
		return "carlist";
	}
	
	 @RequestMapping(value = "/addcar")
	    public String addCar(Model model){
	    	model.addAttribute("car", new Car());
	    	model.addAttribute("salesmans", srepository.findAll());
	        return "addcar";
	    }   
	 
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Car car){
	        repository.save(car);
	        return "redirect:carlist";
	    } 
	 
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteCar(@PathVariable("id") Long Id, Model model) {
	    	repository.deleteById(Id);
	        return "redirect:../carlist";
	    }
	 
	 // heroku testi
	 @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	    public String editBook(@PathVariable("id") Long Id, Model model) {
	    	Car car = repository.findCarsById(Id);
	    	model.addAttribute("car", car);
	    	model.addAttribute("salesmans", srepository.findAll());
	        return "editcar";
	    }
	 
	 	// RESTful service to get all students
	    @RequestMapping(value="/cars", method = RequestMethod.GET)
	    public @ResponseBody List<Car> studentListRest() {	
	        return (List<Car>) repository.findAll();
	    }    

		// RESTful service to get student by id
	    @RequestMapping(value="/car/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Car> findStudentRest(@PathVariable("id") Long carId) {	
	    	return repository.findById(carId);
	    }       
	
}
