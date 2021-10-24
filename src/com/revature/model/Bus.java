package com.revature.model;

public class Bus {

	
	public int numberOfWheels;
	public int year; 
	public String model;
	public String type; 
	
	public Bus() {	
	}
	
	public Bus(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}
	
	public Bus(int numberOfWheels, int year) {
		this(numberOfWheels);
		this.year = year;
	}
	
	public Bus(int numberOfWheels, int year, String model) {
		this(numberOfWheels, year);
		this.model = model;
	}
	
		public Bus(int numberOfWheels, int year, String model, String type) {
		
		this(numberOfWheels, year, model); 
		this.type = type;
	}
	
	
	
	
}