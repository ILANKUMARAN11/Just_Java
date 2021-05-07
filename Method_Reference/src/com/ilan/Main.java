package com.ilan;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		List<String> names = new ArrayList<String>();

		names.add("ilan");
		names.add("kumaran");
		names.add("ganesh");

		List<String> namesUpperCase = names.stream().map(String::toUpperCase).collect(Collectors.toList());

		System.out.println(namesUpperCase);

	}
}
