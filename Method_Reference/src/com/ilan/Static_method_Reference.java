package com.ilan;

import java.util.ArrayList;
import java.util.List;

public class Static_method_Reference {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();

		names.add("ilan");
		names.add("kumaran");
		names.add("ganesh");

		names.forEach(System.out::println);
	
	}

}
