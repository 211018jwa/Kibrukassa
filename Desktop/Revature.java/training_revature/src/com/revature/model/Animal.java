package com.revature.model;

public class Animal {
	// Objects: contain fields (properties) and behaviors (methods)

	public String species;
	public String name;
	public int age;
	public int energyLevel;

	public Animal(String species, String name, int age, int energyLevel) {
		this.species = species;
		this.name = name;
		this.age = age;
		this.energyLevel = energyLevel;
	}

	 {
		// TODO Auto-generated constructor stub
	}

	/*
	 * Methods: A method is a block of code that can be executed whenever it is invoked within another method
	 * 
	 * Methods that do not have the "static" modifier are known as "instance methods"
	 * 
	 * Instance methods are methods that belong to a particular object and can modify and access the instance properties of that object.
	 */
	public void play() {
		System.out.println(this.name + " is playing!");
		this.energyLevel = this.energyLevel - 10;
	}

	// Method overloading: If you have 2 or more methods with the same name defined in the same class, but with different numbers of parameters / type of parameters
	// 	For all intents and purposes, from the perspective of the JVM when the program is being ran, overloaded methods are NOT related in any way
	//	Overloaded methods are two totally different methods from each other
	public void play(String game) {
		System.out.println(this.name + " is playing " + game + "!");
		this.energyLevel = this.energyLevel - 10;
	}

	public void play(int energyLevelDecrease) {
		System.out.println(this.name + " is playing!");
		this.energyLevel = this.energyLevel - energyLevelDecrease;
	
	}



}