package com.revature.app;

public class Driver {

	public static void main(String[] args) {
		String s1= "Hello world";
		char[] mycharacter= {'H','e','l','l','o' , ' ',  'w','o','r','l','d' };
		String s2= new String(mycharacter);
		System.out.println( s1 );
		System.out.println(s2);
		System.out.println(s1 == s2 );
	}

}
