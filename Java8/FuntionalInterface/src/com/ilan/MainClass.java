package com.ilan;


@FunctionalInterface
interface Ilan{
	
	void add();
	
	static void sub() {
		System.out.println("Sub of Ilan");
	}
	
	default void divide() {
		System.out.println("Divide of Ilan");
	}
	
}


@FunctionalInterface
interface Ranjani{
	
	void add();
	
	static void sub() {
		System.out.println("Sub of Ranjani");
	}
	
	default void divide() {
		System.out.println("Divide of Ranjani");
	}
}

public class MainClass implements Ilan,Ranjani {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ilan.sub();
		Ranjani.sub();
	}

	@Override
	public void add() {
		
		
	}

	@Override
	public void divide() {
		
		Ilan.super.divide();
		Ranjani.super.divide();
	}

}
