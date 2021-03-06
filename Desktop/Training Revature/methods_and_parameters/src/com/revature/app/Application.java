package com.revature.app;

import com.revature.model.Animal;
import com.revature.model.Food;

public class Application {

	public static void main(String[] args) {

		printHelloWorld();
		
		Animal animal1 = new Animal("Dog", "Fido", 7, 100);
		System.out.println(animal1.energyLevel);

		animal1.play("fetch");

		System.out.println(animal1.energyLevel);

		animal1.play(30);

		System.out.println(animal1.energyLevel);

		animal1.play();

		System.out.println(animal1.energyLevel);

		Food food = new Food("Steak", 50);

		animal1.eat(food);

		System.out.println(animal1.energyLevel);
	}

	public static void printHelloWorld() {
		System.out.println("Hello World!");
		System.out.println("Hello World!");
		System.out.println("Hello World!");
	}

}