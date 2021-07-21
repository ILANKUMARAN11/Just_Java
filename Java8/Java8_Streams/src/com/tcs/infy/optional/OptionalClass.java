package com.tcs.infy.optional;

import java.util.Optional;

public class OptionalClass {

	public static void main(String[] args) {

		String str = "test";

		String optionalStr = Optional.ofNullable(str)
				.filter(s->s.startsWith("t"))
				.map(String::toUpperCase).orElse("Deafult");
		
		System.out.println(optionalStr);

		// System.out.println(Optional.ofNullable(null).orElseGet(ArrayList::new));

		String test = "";

		System.out.println(Optional.ofNullable(test).orElseGet(() -> "DATA"));
		
		//-----
		
		
	}

}
