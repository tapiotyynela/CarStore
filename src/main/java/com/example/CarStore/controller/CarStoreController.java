package com.example.CarStore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
	
	// Ohjataan kirjautumiseen
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	// Luodaan endpoint sovelluksen etusivulle jossa näkyy lista myytävistä autoista
    @PreAuthorize("hasAuthority('USER')")
	 @RequestMapping(value="/carlist", method = RequestMethod.GET)
	    public String carList(Model model) {	
	        model.addAttribute("cars", repository.findAll());
	        return "carlist";
}
	// Luodaan endpoint sovelluksen toiminnolle jossa voi lisätä myytävän auton
	 @RequestMapping(value = "/addcar")
	    public String addCar(Model model){
	    	model.addAttribute("car", new Car());
	    	model.addAttribute("salesmans", srepository.findAll());
	        return "addcar";
	    }   
	 // endpoint joka palauttaa myytävien autojen listan uuden auton tallentamisen jälkeen.
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Car car){
	        repository.save(car);
	        return "redirect:carlist";
	    } 
	 // endpoint joka auton deletoinnin jälkeen palauttaa etusivun
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteCar(@PathVariable("id") Long Id, Model model) {
	    	repository.deleteById(Id);
	        return "redirect:../carlist";
	    }
	 
	 // endpoint joka näyttää sivun jossa voi muokata yksittäistä autoa 
	 @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	    public String editBook(@PathVariable("id") Long Id, Model model) {
	    	Car car = repository.findCarsById(Id);
	    	model.addAttribute("car", car);
	    	model.addAttribute("salesmans", srepository.findAll());
	        return "editcar";
	    }
	 
	 	// endpoint joka palauttaa json muotoisen rest apin myytävistä autoista
	    @RequestMapping(value="/cars", method = RequestMethod.GET)
	    public @ResponseBody List<Car> carListRest() {	
	        return (List<Car>) repository.findAll();
	    }    

		// endpoint joka palauttaa json muotoisen rest apin yhdestä autosta id:n mukaan
	    @RequestMapping(value="/car/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Car> findStudentRest(@PathVariable("id") Long carId) {	
	    	return repository.findById(carId);
	    }   
	      
	
}
