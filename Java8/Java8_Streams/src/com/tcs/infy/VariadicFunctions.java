package com.tcs.infy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VariadicFunctions {

	public static void main(String[] args) {

		VariadicFunctions m = new VariadicFunctions();

		System.out.println(">>>>>" + m.alpha("One", "Two"));

		String arr[] = { "Three", "Four" };

		System.out.println(">>>>>" + m.alpha(arr));

	}

	public List<String> alpha(String... input) {
		String arr[] = input;
		return Arrays.stream(arr).collect(Collectors.toList());
	}

}
