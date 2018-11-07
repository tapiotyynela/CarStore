package com.example.CarStore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	
	private long id;
	private String type;
	private String brand;
	private String model;
	private String bodyStyle;
	private String year;
	private String colour;
	private String transmission;
	private String gasType;
	private String registerNumber;
	private double price;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name= "salesmanID")
	private SalesMan salesman;
	
	public Car() {
		
	}
	
	public Car(String type, String brand, String model, String bodyStyle, String year, String colour, String transmission, String gasType, String registerNumber, double price, SalesMan salesman) {
		
		this.type = type;
		this.brand = brand;
		this.model = model;
		this.bodyStyle = bodyStyle;
		this.year = year;
		this.colour = colour;
		this.transmission = transmission;
		this.gasType = gasType;
		this.registerNumber = registerNumber;
		this.price = price;
		this.salesman = salesman;
	}
	
	
	
	
	public void setSalesman(SalesMan salesman) {
		this.salesman = salesman;
	}

	public SalesMan getSalesman() {
		return salesman;
	}

	public long getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public String getBodyStyle() {
		return bodyStyle;
	}
	public String getYear() {
		return year;
	}
	public String getColour() {
		return colour;
	}
	public String getTransmission() {
		return transmission;
	}
	public String getGasType() {
		return gasType;
	}
	public String getRegisterNumber() {
		return registerNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setBodyStyle(String bodyStyle) {
		this.bodyStyle = bodyStyle;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public void setGasType(String gasType) {
		this.gasType = gasType;
	}
	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", type=" + type + ", brand=" + brand + ", model=" + model + ", bodyStyle=" + bodyStyle
				+ ", year=" + year + ", colour=" + colour + ", transmission=" + transmission + ", gasType=" + gasType
				+ ", registerNumber=" + registerNumber + ", price=" + price + ", salesman=" + salesman + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
