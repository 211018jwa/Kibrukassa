package com.revature.model;

public class Animal {

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
		
	public void play() {
		System.out.println(this.name + " is playing!");
		this.energyLevel = this.energyLevel - 10;
	}
	
		public void play(String game) {
		System.out.println(this.name + " is playing " + game + "!");
		this.energyLevel = this.energyLevel - 10;
	}
		
	public void play(int energyLevelDecrease) {
		System.out.println(this.name + " is playing!");
		this.energyLevel = this.energyLevel - energyLevelDecrease;
	}
	
	public void eat(Food food) {
		System.out.println(this.name + " is eating " + food.name);
		this.energyLevel = this.energyLevel + food.calories;
	}
	

	
}