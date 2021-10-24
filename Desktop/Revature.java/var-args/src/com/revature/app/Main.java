package com.revature.app;

public class Main {

	public static void main(String... args) { // ... is what is known as var-args
		// The purpose of var-args is to have the ability to provide an arbitrary number of parameters (of a particular type)

		System.out.println("Hello " + args[0] + " " + args[1]);

		// This case will be using the overloaded getSum method with 2 double parameters
		System.out.println(getSum(10.5, 5.757));

		System.out.println(getSum(1.5, 2.5, 3.2, 4.5, 10, 11.1, 15, 1000, 20000));
	}

	public static double getSum(double a, double b) {
		System.out.println("getSum with 2 doubles invoked");
		return a + b;
	}

	// Two rules for var-args:
	// 	1. var-args must go at the end of the parameter list
	//  2. You can only have one var-arg for a parameter

	// Var-args is 0 or more parameters
	public static double getSum(double d1, double d2, double... numbers) { // "double... numbers" is a var-arg parameter
		// The numbers variable that is defined in the parameters of this method
		// The numbers variable is a reference variable to a double array
		System.out.println("getSum with var-args invoked");

		double sum = 0;
		sum += d1;
		sum += d2;

		for (double num : numbers) {
			sum += num;
		}

		return sum;
	}

}