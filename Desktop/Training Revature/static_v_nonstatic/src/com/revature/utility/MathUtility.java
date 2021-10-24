package com.revature.utility;

public class MathUtility { // The Math Utility class contains static methods that are useful to perform math operations

	public static int power(int base, int exponent) {
		int result = 1;
		
		for (int i = 1; i <= exponent; i++) {
			result *= base; 
		}
			
		return result;
	}
	
	public static double calculateCircleArea(double radius) {
		return 3.14159 * radius * radius;
	}
	
}
