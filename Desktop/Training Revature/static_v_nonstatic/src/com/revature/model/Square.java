package com.revature.model;

public class Square {

	public double side; 
	public static int numberOfInstances; 
	
	public Square(double side) {
		this.side = side;
		
		numberOfInstances++; 
	}
	
}