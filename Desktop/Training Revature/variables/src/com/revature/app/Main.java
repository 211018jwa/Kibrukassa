package com.revature.app;

import com.revature.model.Bus;

public class Main {

	public static void main(String[] args) {
		
		primitiveExamples();
		System.out.println();
		referenceExamples();

	}
	
	public static void primitiveExamples() {
		
		byte myByte; 
		myByte = 10; 
		System.out.println("myByte = " + myByte); 
		
		byte anotherByte = 10;
		
		System.out.println("anotherByte = " + anotherByte); 
		
		short myShort = 25_767; 
		System.out.println("myShort = " + myShort);
		
		char myChar = 'A'; 
		System.out.println("myChar = " + myChar);
		int myInt = 2_000_123_100;
		System.out.println("myInt = " + myInt);
		long myLong = 32131232131231233L; 
		System.out.println("myLong = " + myLong);
		float myFloat = 3.14159f; 
		System.out.println("myFloat = " + myFloat);
		
		double myDouble = 3.14159; 
		System.out.println("myDouble = " + myDouble);
		
		
		boolean myBoolean = true;
		myBoolean = false;
		
		myBoolean = (10 == 100); 
		System.out.println("myBoolean = " + myBoolean);
	}
	
	public static void referenceExamples() {
		Bus bus1 = null;
		bus1 = new Bus(); 
		
		
		bus1.model = "Greyhound";
		bus1.type = "Express";
		bus1.year = 2021;
		bus1.numberOfWheels = 18;
		
		System.out.println(bus1.model);
		System.out.println(bus1.numberOfWheels);
		System.out.println(bus1.type);
		System.out.println(bus1.year);
		
		Bus bus2 = new Bus(8, 2020, "Some Model", "Express"); 
		
		System.out.println(bus2.model);
		System.out.println(bus2.numberOfWheels);
		System.out.println(bus2.type);
		System.out.println(bus2.year);
		
		Bus bus3 = new Bus(12, 2018, "Another Model", "City");
		bus2 = bus3; 
		bus3 = null;
		
	}

}