package com.revature.app;

import com.revature.model.Square;
import com.revature.utility.MathUtility;

public class Main {

	public static void main(String[] args) {

		Main.aStaticMethod();
		aStaticMethod(); // Because aStaticMethod is in the same class as where we are invoking the method, we do not need to reference the <Class name>.<methodName>();

		int result = MathUtility.power(2, 4); // power is an example of a static method that we can access from another class
		System.out.println("2 to the power of 4 is " + result);

		double area = MathUtility.calculateCircleArea(5);
		System.out.println("area of a circle with radius 5 is " + area);

		Square s1 = new Square(5);
		Square s2 = new Square(10);
		Square s3 = new Square(15);

		System.out.println("numberOfInstances = " + Square.numberOfInstances); // Because numberOfInstances is a static variable, it belongs to the Square class itself
		// However, static variables are also shared among all instances of that class

		Square.numberOfInstances = 10000;

		System.out.println(s1.numberOfInstances);
		System.out.println(s2.numberOfInstances);
		System.out.println(s3.numberOfInstances);

		// Math is a class that is included within the Java runtime libraries (which if you remember, are included inside of a JRE)
		// abs is a static method defined in this Math class
		// The reason we do not need to import this Math class is because it exists in a special package known as java.lang
		// Every class that is contained inside the java.lang package is made available by default
		System.out.println("absolute value of -10.5 is " + Math.abs(-10.5));

		blockAndMethodScopeExample();
	}

	public static void aStaticMethod() {
		System.out.println("Invoked aStaticMethod()");
	}

	/*
	 * Variable scopes
	 * 
	 * 	1. Class scope (sometimes known as global scope): any field that has the static keyword is class scoped. This means the variable belongs to the class itself.
	 *  2. Instance scope: any field that is non-static (does not have the static keyword) is instance scoped. This means that every single instance has its own copy of this variable
	 *  3. Method scope: any variable that is declared inside of a method is method scoped. This means that you can only access this variable within that particular method, and the variable
	 *  	is destroyed whenever the method is done executing. (this method exists within the stack frame)
	 *  4. Block scope: within methods, we can have different code blocks (if statement blocks, for loops, while loops, etc.) Variables that are declared inside of those blocks are only available
	 *  	within those blocks
	 */

	public static void blockAndMethodScopeExample() {
		int a = 10; // method scoped variable
		if (true) {

			a += 20; // can be accessed inside of a block within that method

			System.out.println(a);

			int b = 100; // block scoped variable

			System.out.println(b); // can only be accessed within the block and is destroyed whenever the block is done executing
		}

		System.out.println(a);

		// method scope variable are destroyed when the method is done executing.
	}

}
