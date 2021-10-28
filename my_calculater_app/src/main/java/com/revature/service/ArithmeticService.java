package com.revature.service;

public class ArithmeticService {

	public String doAddition(String number1String, String number2String) {

		double number1 = Double.parseDouble(number1String);
		double number2 = Double.parseDouble(number2String);
		double sum = number1 + number2;
			
		String result = "" + sum; // Convert from double representation of a number to a String representation
		
		return result;
	}

	public String doSubtraction(String number1String, String number2String) {
		double number1 = Double.parseDouble(number1String);
		double number2 = Double.parseDouble(number2String);
		double difference = number1 - number2;
		
		String differnce = "" + difference; // Convert from double representation of a number to a String representation
		
		return differnce;
	}

	public String doMultiplication(String number1String, String number2String) {
		double number1 = Double.parseDouble(number1String);
		double number2 = Double.parseDouble(number2String);
		
		double product = number1 * number2;
		
		String multiply = "" + product; // Convert from double representation of a number to a String representation
		
		return multiply;
	}

	public String doDivision(String number1String, String number2String) {
		double number1 = Double.parseDouble(number1String);
		double number2 = Double.parseDouble(number2String);
		
		double divide = number1 / number2;
		
		String division = "" + divide; // Convert from double representation of a number to a String representation
		
		return division;
	}
	
}
