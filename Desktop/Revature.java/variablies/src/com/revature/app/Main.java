package com.revature.app;

import com.revature.model.Bus;

public class Main {

	// This is a single line comment

	/*
	 * This is a multi-line comment
	 * 
	 * We can have as many lines as we want to be treated as comments between '/*' and '* /'
	 * 
	 * 
	 */

	/*
	 * Variables
	 * 
	 * What types of variables do we have in Java?
	 * 	1. primitive variables: directly store values "within them" in memory
	 *  2. reference variables: refer to other locations in memory. In particular, reference variables "point" to the location of objects in memory
	 *  
	 *  Within memory (RAM), we have two separate areas of memory: the stack and the heap
	 *  
	 * What types of primitive variables do we have?
	 * 
	 * 3 Overarching primitive types:
	 * 	1. boolean
	 * 	2. integral types (byte, short, char, int, long)
	 * 		char is a special one that is intended to store characters
	 * 	3. floating-point types (float and double)
	 *  
	 *  1. boolean: technically 1 bit, JVM dependent (sometimes the JVM allocates, for example 8 bits, but in reality you just need 1 bit)
	 *  2. byte: 8 bits (bits are the smallest units of data that can be either 0 or 1)
	 *  	-128 to 127
	 *  	Whole numbers only (integral types)
	 *  3. short: 16 bits
	 *  	-32768 to 32767
	 *  	Whole numbers only (integral types)
	 *  4. char: 16 bits
	 *  	0 to 65535
	 *  	Whole numbers only (integral types)
	 *  	however, typically not used to store numbers
	 *  	this variable type is instead used to store a single character such as 'a', 'A', '@', '$', 'Z', '1'
	 *  5. int: 32 bits
	 *  	-2,147,483,648 to 2,147,483,647
	 *  	Whole numbers only (integral types)
	 *  6. long: 64 bits
	 * 		-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
	 * 		Whole numbers only (integral types)
	 * 	7. float: 32 bits
	 *  	+- 1.2 * 10^-38 to 3.4 * 10^38
	 *  	Represent numbers with decimals (floating point type)
	 * 	8. double: 64 bits
	 *  	+- 2.3 * 10^-308 to 1.7 * 10^308
	 *  	Represent numbers with decimals (floating point type)
	 */

	public static void main(String[] args) {

		primitiveExamples();
		System.out.println();
		referenceExamples();

	}

	public static void primitiveExamples() {
		// Primitives: primitives directly store values "within them" in memory

		/*
		 * Integral Types
		 */

		// 8 bits
		byte myByte; // Variable declaration
		myByte = 10; // initializing the variable. Initialization = the initial assignment of a value to a local variable (local is a type of variable scope- we will learn more about this later)
		System.out.println("myByte = " + myByte); // String + byte -> the byte gets converted into a string -> String + String = String

		byte anotherByte = 10; // declaring and initializing on the same line

		System.out.println("anotherByte = " + anotherByte); // String + byte -> byte gets converted to a string -> String + String = String

		// 16 bits
		short myShort = 25_767; // _ is for readability, you cannot use "," to separate digits. _ cannot be at the beginning or end of the number
		System.out.println("myShort = " + myShort);

		char myChar = 'A'; // 'A' is an example of a "char literal"
		System.out.println("myChar = " + myChar);

		// 32 bits
		int myInt = 2_000_123_100;
		System.out.println("myInt = " + myInt);

		// 64 bits
		long myLong = 32131232131231233L; // With the L, we signify that this number is a "Long literal"
		System.out.println("myLong = " + myLong);
		/*
		 * Floating Types
		 */
		float myFloat = 3.14159f; // A decimal number by default is a "double literal". Doubles are larger than floats, so we need to explicitly specify
		// a "float literal" by putting f at the end of the number
		System.out.println("myFloat = " + myFloat);

		double myDouble = 3.14159; // 3.14159 is a "double literal" that can fit into a double
		System.out.println("myDouble = " + myDouble);

		/*
		 * Boolean Type
		 */

		boolean myBoolean = true;
		myBoolean = false;

		myBoolean = (10 == 100); // false
		System.out.println("myBoolean = " + myBoolean);
	}

	public static void referenceExamples() {
		// Reference Variables: refer to the location of an object
		Bus bus1 = null; // Because Bus is in a different package, we must import it
		// reference variables can either be null or be pointing to an object

		// Without the reference variable actually pointing to an object, whenever we try to access the properties from that reference variable, it will give us a NullPointerException
		// So, we need to actually instantiate an object, and have the reference variable point to that object
		bus1 = new Bus(); 
		// new Bus() is what creates a Bus object. 
		// bus1 = ... is what points the bus1 variable to that newly created object

		bus1.model = "Greyhound";
		bus1.type = "Express";
		bus1.year = 2021;
		bus1.numberOfWheels = 18;

		System.out.println(bus1.model);
		System.out.println(bus1.numberOfWheels);
		System.out.println(bus1.type);
		System.out.println(bus1.year);

		Bus bus2 = new Bus(8, 2020, "Some Model", "Express"); // We are passing in 4 values (arguments)

		System.out.println(bus2.model);
		System.out.println(bus2.numberOfWheels);
		System.out.println(bus2.type);
		System.out.println(bus2.year);

		Bus bus3 = new Bus(12, 2018, "Another Model", "City");

		bus2 = bus3; // We are copying the location of the object bus3 is pointing to over to bus2
		// This means that both bus2 and bus3 are referencing the same object in memory

		// The original object that bus2 was pointing to, which now has 0 references, will be garbage collected
		bus3 = null;

	}

}
