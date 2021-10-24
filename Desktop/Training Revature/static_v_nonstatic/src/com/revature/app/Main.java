package com.revature.app;

import com.revature.model.Square;
import com.revature.utility.MathUtility;

public class Main {
	
	public static void main(String[] args) {
			
		Main.aStaticMethod();
		aStaticMethod(); 
		
		int result = MathUtility.power(2, 4); 
		System.out.println("2 to the power of 4 is " + result);
			
		double area = MathUtility.calculateCircleArea(5);
		System.out.println("area of a circle with radius 5 is " + area);
		
		Square s1 = new Square(5);
		Square s2 = new Square(10);
		Square s3 = new Square(15);
		
		System.out.println("numberOfInstances = " + Square.numberOfInstances); 
		
		Square.numberOfInstances = 10000;
		
		System.out.println(s1.numberOfInstances);
		System.out.println(s2.numberOfInstances);
		System.out.println(s3.numberOfInstances);
		System.out.println("absolute value of -10.5 is " + Math.abs(-10.5));

		blockAndMethodScopeExample();
	}
	
	public static void aStaticMethod() {
		System.out.println("Invoked aStaticMethod()");
	}
	
	public static void blockAndMethodScopeExample() {
		int a = 10; 
		if (true) {
			a += 20;
			System.out.println(a);
			int b = 100; 
			
			System.out.println(b); 
		}
		
		System.out.println(a);
		
	}

}
