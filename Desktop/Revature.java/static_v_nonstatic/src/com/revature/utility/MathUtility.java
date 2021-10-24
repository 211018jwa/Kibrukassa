package com.revature.utility;

public class MathUtility { // The Math Utility class contains static methods that are useful to perform math operations

	// This method is used to compute exponents 
	// For example 2^4 = 2 * 2 * 2 * 2
	public static int power(int base, int exponent) {
		int result = 1;

		for (int i = 1; i <= exponent; i++) {
//			result = result * base;
			result *= base; // This is shorthand for result = result * base
		}

		// result += 2 is the same as result = result + 2
		// result -= 2 is the same as result = result - 2
		// result /= 2 is the same as result = result / 2
		// result *= 2 is the same as result = result * 2
		// result %= 2 is the same as result = result % 2 -> 14 % 2 = 0 (14 "mod" 2), 15 % 2 = 1

		return result;
	}

	public static double calculateCircleArea(double radius) {
		return 3.14159 * radius * radius;
	}

}
