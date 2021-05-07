package com.tcs.infy;

import java.util.List;
import java.util.function.Function;

public class MainClass {
	
	

	
	
	public  static void superGeneric(List<? super Number> lst)
	{
		Integer i=new Integer(12);
		Double d=new Double(12);
		Float f=new Float(12);
	
		lst.add(i);
		lst.add(d);
		lst.add(f);
	}
	
	public static void extendsGeneric(List<? extends Number> lst)
	{
		Number i=new Integer(12);
		Double d=new Double(12);
		Float f=new Float(12);
	
		lst.add(i);
		lst.add(d);
		lst.add(f);
	}

	public static void main(String[] args) {
		
		
		

	}

}
