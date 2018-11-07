package com.example.CarStore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SalesMan {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private long salesmanID;
	private String firstName;
	private String lastName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "salesman")
	private List<Car> Cars;
	
	public SalesMan() {
		
	}
	
	public SalesMan(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		
	}

	
	public long getSalesmanID() {
		return salesmanID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public List<Car> getCars() {
		return Cars;
	}
	
	public void setSalesmanID(long salesmanID) {
		this.salesmanID = salesmanID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCars(List<Car> cars) {
		Cars = cars;
	}

	@Override
	public String toString() {
		return "SalesMan [salesmanID=" + salesmanID + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	



	
	
	

	
}
